package com.vonage.game;

import com.vonage.game.model.Board;
import com.vonage.game.model.Piece;
import com.vonage.game.model.moves.IMove;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GameEngine {
    final Board board;
    final Piece piece;
    final MovesListParser movesListParser;

    public String play(String moves) {
        List<IMove> parsed = movesListParser.parse(moves);
        parsed.forEach(move -> move.move(piece, board));
        return piece.getCurrentX() + " " + piece.getCurrentY() + " " + piece.getFacing();
    }
}
