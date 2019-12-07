package com.imc.game.strategies;

import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

@RunWith(JMockit.class)
public class RandomStrategyImplTest {
    private GameStrategy randomStrategy;

    @Before
    public void init() {
        randomStrategy = new RandomStrategyImpl();
    }

    @Test
    public void getComputerSelectionTest() {
        new MockUp<Random>() {
            @Mock
            public int nextInt(int bound) {
                return 1;
            }
        };

        Assert.assertEquals(1, randomStrategy.getComputerSelection());
    }
}
