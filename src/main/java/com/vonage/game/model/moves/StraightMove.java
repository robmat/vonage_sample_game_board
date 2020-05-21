package com.vonage.game.model.moves;

import com.vonage.GameException;
import com.vonage.game.model.Board;
import com.vonage.game.model.FacingDirection;
import com.vonage.game.model.MovingDirection;
import com.vonage.game.model.Piece;
import lombok.EqualsAndHashCode;

import java.util.function.BiConsumer;

@EqualsAndHashCode
public class StraightMove implements IMove {

    MovingDirection movingDirection = MovingDirection.FORWARD;

    @Override
    public void move(Piece piece, Board board) {
        FacingDirection facing = piece.getFacing();
        FacingDirection.Plane plane = facing.getPlane();

        BiConsumer<Piece, Integer> set;
        int coordinate;

        switch (plane) {
            case HORIZONTAL :
                set = Piece::setCurrentX;
                coordinate = piece.getCurrentX();
                break;
            case  VERTICAL:
                set = Piece::setCurrentY;
                coordinate = piece.getCurrentY();
                break;
            default: throw new GameException(this.getClass().getSimpleName() + " not supported plane: " + plane);
        }

        int newCoordinate = coordinate + (facing.getMove() * movingDirection.getFactor());
        if (board.isValidCoordinate(newCoordinate, plane)) {
            set.accept(piece, newCoordinate);
        }
    }
}
