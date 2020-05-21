package com.vonage.game;

import com.vonage.game.model.moves.IMove;
import com.vonage.game.model.moves.StraightMove;
import com.vonage.game.model.moves.TurnMove;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.vonage.game.model.TurnDirection.LEFT;
import static com.vonage.game.model.TurnDirection.RIGHT;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MovesListParserTest {

    @Test
    void parse() {
        MovesListParser movesListParser = new MovesListParser();

        List<IMove> result = movesListParser.parse("ĄŹĄ MLR LRM 123");

        assertEquals(result.size(), 6);
        assertEquals(result.get(0), new StraightMove());
        assertEquals(result.get(1), TurnMove.builder().turnDirection(LEFT).build());
        assertEquals(result.get(2), TurnMove.builder().turnDirection(RIGHT).build());
        assertEquals(result.get(3), TurnMove.builder().turnDirection(LEFT).build());
        assertEquals(result.get(4), TurnMove.builder().turnDirection(RIGHT).build());
        assertEquals(result.get(5), new StraightMove());
    }
}