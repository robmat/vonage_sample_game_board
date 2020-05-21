package com.vonage.game.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Piece {
    @Builder.Default
    int currentX = 0;
    @Builder.Default
    int currentY = 0;
    @Builder.Default
    FacingDirection facing = FacingDirection.NORTH;

}
