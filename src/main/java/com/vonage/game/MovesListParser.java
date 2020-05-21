package com.vonage.game;

import com.vonage.game.model.TurnDirection;
import com.vonage.game.model.moves.IMove;
import com.vonage.game.model.moves.StraightMove;
import com.vonage.game.model.moves.TurnMove;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovesListParser {

    public static final char MOVE = 'M';
    public static final char LEFT = 'L';
    public static final char RIGHT = 'R';
    static final List<Integer> ALLOWED_INPUT = Arrays.asList((int)MOVE, (int)LEFT, (int)RIGHT);

    List<IMove> parse(String input) {
        return input.chars()
                .filter(ALLOWED_INPUT::contains)
                .mapToObj(character -> {
            if (character == MOVE) {
                return new StraightMove();
            } else {
                return TurnMove.builder().turnDirection(TurnDirection.parse(character)).build();
            }
        }).collect(Collectors.toList());
    }
}
