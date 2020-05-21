package com.vonage.game.model;

import com.vonage.GameException;
import com.vonage.game.MovesListParser;
import lombok.Getter;

import java.util.Arrays;

public enum TurnDirection {
    LEFT(-1, MovesListParser.LEFT), RIGHT(1, MovesListParser.RIGHT);

    @Getter
    private final int factor;
    private final char character;

    TurnDirection(int factor, char character) {
        this.character = character;
        this.factor = factor;
    }

    public static TurnDirection parse(int character) {
        return Arrays.stream(TurnDirection.values())
                .filter(t -> t.character == character)
                .findFirst()
                .orElseThrow(() -> new GameException(TurnDirection.class + " does not support + " + character));
    }
}
