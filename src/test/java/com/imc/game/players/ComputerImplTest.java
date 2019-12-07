package com.imc.game.players;

import com.imc.game.strategies.GameStrategy;
import com.imc.game.strategies.RandomStrategyImpl;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class ComputerImplTest {
    private Player computerPlayer;
    private GameStrategy gameStrategy = new RandomStrategyImpl();

    @Before
    public void init() {
        computerPlayer = new ComputerImpl(gameStrategy);
    }

    @Test
    public void selectSymbolTest() {
        new MockUp<RandomStrategyImpl>() {
            @Mock
            public int getComputerSelection() {
                return 2;
            }
        };

        Assert.assertEquals(2, computerPlayer.selectSymbol(null));
    }
}
