package com.imc.game.players;

import com.imc.game.enums.PlayerSelection;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Scanner;

@RunWith(JMockit.class)
public class HumanImplTest {
    private Player humanPlayer;
    private int counter;
    private String selections;

    @Before
    public void init() {
        humanPlayer = new HumanImpl();
        counter = 0;
        selections = "Select ROCK or PAPER or SCISSORS:";
    }

    @Test
    public void selectSymbolWithValidSelectionTest() {
        new MockUp<Scanner>() {
            @Mock
            public String next() {
                return PlayerSelection.ROCK.getSelection();
            }
        };

        Assert.assertEquals(0, humanPlayer.selectSymbol(selections));
    }

    @Test
    public void selectSymbolWithFirstInvalidSelectionTest() {
        new MockUp<Scanner>() {
            @Mock
            public String next() {
                counter++;
                return counter < 2 ? "pa" : PlayerSelection.PAPER.getSelection();
            }
        };

        Assert.assertEquals(1, humanPlayer.selectSymbol(selections));
    }
}
