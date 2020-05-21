package com.vonage.game.model;

import lombok.Getter;

public enum MovingDirection {
    FORWARD(1), BACKWARD(-1);

    @Getter
    private final int factor;

    MovingDirection(int factor) {
        this.factor = factor;
    }
}
