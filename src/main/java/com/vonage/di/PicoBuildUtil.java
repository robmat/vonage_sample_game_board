package com.vonage.di;

import com.vonage.game.GameEngine;
import com.vonage.game.MovesListParser;
import com.vonage.game.model.Board;
import com.vonage.game.model.Piece;
import org.picocontainer.PicoContainer;
import org.picocontainer.DefaultPicoContainer;

public class PicoBuildUtil {
    public static PicoContainer build() {
        DefaultPicoContainer container = new DefaultPicoContainer();
        container.addComponent(GameEngine.class);
        container.addComponent(Board.class);
        container.addComponent(Piece.class);
        container.addComponent(MovesListParser.class);
        return container;
    }
}
