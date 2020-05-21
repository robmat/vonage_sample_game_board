package com.vonage.game.model.moves;

import com.vonage.game.model.Board;
import com.vonage.game.model.FacingDirection;
import com.vonage.game.model.Piece;
import com.vonage.game.model.TurnDirection;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.vonage.game.model.FacingDirection.*;
import static com.vonage.game.model.TurnDirection.LEFT;
import static com.vonage.game.model.TurnDirection.RIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TurnMoveTest {

    @ParameterizedTest(name = "Piece {0} should turn {1} and facing expected {2}")
    @MethodSource("moveParameters")
    void move(Piece piece, TurnDirection turnDirection, FacingDirection expected) {
        TurnMove turnMove = TurnMove.builder().turnDirection(turnDirection).build();

        turnMove.move(piece, Board.builder().build());

        assertEquals(piece.getFacing(), expected);
    }

    private static Stream<Arguments> moveParameters() {
        return Stream.of(
                Arguments.of(Piece.builder().facing(NORTH).build(), LEFT, WEST),
                Arguments.of(Piece.builder().facing(NORTH).build(), RIGHT, EAST),
                Arguments.of(Piece.builder().facing(SOUTH).build(), LEFT, EAST),
                Arguments.of(Piece.builder().facing(WEST).build(), RIGHT, NORTH)
        );
    }
}