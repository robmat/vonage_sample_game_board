package com.vonage.game.model;

import lombok.Getter;

public enum FacingDirection {
    NORTH(Plane.VERTICAL, 1), EAST(Plane.HORIZONTAL, 1), SOUTH(Plane.VERTICAL, -1), WEST(Plane.HORIZONTAL, -1);

    @Getter
    private final Plane plane;
    @Getter
    private final int move;

    FacingDirection(Plane plane, int move) {
        this.plane = plane;
        this.move = move;
    }

    public enum Plane {HORIZONTAL, VERTICAL}

    @Override
    public String toString() {
        return name().substring(0, 1);
    }
}
