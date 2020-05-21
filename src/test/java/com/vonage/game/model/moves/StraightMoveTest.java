package com.vonage.game.model.moves;

import com.vonage.game.model.Board;
import com.vonage.game.model.FacingDirection;
import com.vonage.game.model.Piece;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.vonage.game.model.FacingDirection.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StraightMoveTest {

    private final Board board = Board.builder().maxX(5).maxY(5).build();

    @ParameterizedTest(name = "Moving from {0},{1} facing {2} results in {3},{4}")
    @MethodSource("moveParameters")
    void move(int curX, int curY, FacingDirection direction, int expX, int expY) {
        StraightMove straightMove = new StraightMove();

        Piece piece = Piece.builder().currentX(curX).currentY(curY).facing(direction).build();

        straightMove.move(piece, board);

        assertEquals(piece.getCurrentX(), expX);
        assertEquals(piece.getCurrentY(), expY);
    }

    private static Stream<Arguments> moveParameters() {

        return Stream.of(
                Arguments.of(0, 0, NORTH, 0, 1),
                Arguments.of(0, 0, SOUTH, 0, 0),
                Arguments.of(4, 4, EAST, 4, 4),
                Arguments.of(4, 4, WEST, 3, 4)
        );
    }
}