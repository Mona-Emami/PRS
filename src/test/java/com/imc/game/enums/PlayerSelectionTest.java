package com.imc.game.enums;

import org.junit.Assert;
import org.junit.Test;

public class PlayerSelectionTest {
    @Test
    public void getByIndexWithValidIndexTest() {
        Assert.assertEquals(PlayerSelection.PAPER, PlayerSelection.getByIndex(1));
    }

    @Test
    public void getByIndexWithInvalidIndexTest() {
        Assert.assertNull(PlayerSelection.getByIndex(7));
    }

    @Test
    public void getPlayerSelectionsCountTest() {
        Assert.assertEquals(3, PlayerSelection.getPlayerSelectionsCount());
    }

    @Test
    public void getBySelectionWithValidInputTest() {
        Assert.assertEquals(PlayerSelection.ROCK, PlayerSelection.getBySelection("rock"));
    }

    @Test
    public void getBySelectionWithInvalidInputTest() {
        Assert.assertNull(PlayerSelection.getBySelection("ro"));
    }
}