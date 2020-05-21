package com.vonage.game.model.moves;

import com.vonage.game.model.Board;
import com.vonage.game.model.Piece;

public interface IMove {
    void move(Piece piece, Board board);
}
