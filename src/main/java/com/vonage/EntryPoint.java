package com.vonage;

import com.vonage.di.PicoBuildUtil;
import com.vonage.game.GameEngine;
import org.picocontainer.PicoContainer;

public class EntryPoint {
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("Usage: java -jar vonage-game.jar LMR...");
            return;
        }
        PicoContainer container = PicoBuildUtil.build();
        System.out.println(container.getComponent(GameEngine.class).play(args[0]));
    }
}
