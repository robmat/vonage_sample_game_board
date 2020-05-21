package com.vonage.game.model.moves;

import com.vonage.game.model.Board;
import com.vonage.game.model.FacingDirection;
import com.vonage.game.model.Piece;
import com.vonage.game.model.TurnDirection;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode
public class TurnMove implements IMove {

    final TurnDirection turnDirection;

    @Override
    public void move(Piece piece, Board board) {
        int oldFacing = piece.getFacing().ordinal();
        int newFacing = oldFacing + turnDirection.getFactor();
        if (newFacing == FacingDirection.values().length) {
            newFacing = 0;
        }
        if (newFacing == -1) {
            newFacing = FacingDirection.values().length  - 1;
        }
        piece.setFacing(FacingDirection.values()[newFacing]);
    }
}
