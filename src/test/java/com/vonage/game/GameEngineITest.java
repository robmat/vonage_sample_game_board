package com.vonage.game;

import com.vonage.di.PicoBuildUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameEngineITest {

    private GameEngine engine;

    @BeforeEach
    void setUp() {
        engine = PicoBuildUtil.build().getComponent(GameEngine.class);
    }

    @Test
    @DisplayName("MRMLMRM should result in 2 2 E position")
    void leftMoveRightMove() {
        assertEquals("2 2 E", engine.play("MRMLMRM") );
    }

    @Test
    @DisplayName("RMMMLMM should result in 3 2 N position")
    public void rightThenUp() {
        assertEquals("3 2 N", engine.play("RMMMLMM"));
    }

    @Test
    @DisplayName("MRMLMRM should result in 0 4 N position")
    public void upAndHitWall() {
        assertEquals("0 4 N", engine.play("MMMMM"));
    }
}