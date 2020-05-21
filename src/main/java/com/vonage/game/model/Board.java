package com.vonage.game.model;

import com.vonage.GameException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.vonage.game.model.FacingDirection.Plane.HORIZONTAL;
import static com.vonage.game.model.FacingDirection.Plane.VERTICAL;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Board {
    @Builder.Default
    int maxX = 5;
    @Builder.Default
    int maxY = 5;

    public boolean isValidCoordinate(int newCoordinate, FacingDirection.Plane plane) {
        if (HORIZONTAL.equals(plane)) {
            return newCoordinate >= 0 && newCoordinate < maxX;
        }
        if (VERTICAL.equals(plane)) {
            return newCoordinate >= 0 && newCoordinate < maxY;
        }
        throw new GameException(this.getClass().getSimpleName() + " not supported plane " + plane);
    }
}
