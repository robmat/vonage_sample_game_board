package com.vonage.game.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.vonage.game.model.FacingDirection.Plane.HORIZONTAL;
import static com.vonage.game.model.FacingDirection.Plane.VERTICAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BoardTest {

    @ParameterizedTest(name = "Should validate {2} {1} on {0} board as {3}")
    @MethodSource("isValidCoordinateParams")
    void isValidCoordinate(Board board, int coordinate, FacingDirection.Plane plane, boolean expected) {
        assertEquals(board.isValidCoordinate(coordinate, plane), expected);
    }

    private static Stream<Arguments> isValidCoordinateParams() {
        return Stream.of(
                Arguments.of(Board.builder().maxX(1).maxY(1).build(), 0, HORIZONTAL, true),
                Arguments.of(Board.builder().maxX(1).maxY(1).build(), 0, VERTICAL, true),
                Arguments.of(Board.builder().maxX(1).maxY(1).build(), 1, HORIZONTAL, false),
                Arguments.of(Board.builder().maxX(1).maxY(1).build(), -1, VERTICAL, false),
                Arguments.of(Board.builder().maxX(1).maxY(100).build(), 1, HORIZONTAL, false)
        );
    }
}