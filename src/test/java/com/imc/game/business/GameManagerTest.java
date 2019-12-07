package com.imc.game.business;

import com.imc.game.players.ComputerImpl;
import com.imc.game.players.HumanImpl;
import mockit.Mock;
import mockit.MockUp;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMockit.class)
public class GameManagerTest {
    private GameManager gameManager;
    private int counter;

    @Before
    public void init() {
        gameManager = new GameManager();
        counter = 0;
    }

    @Test
    public void playGameWithTieTest() {
        new MockUp<HumanImpl>() {
            @Mock
            public int selectSymbol(String selections) {
                return 0;
            }
        };

        new MockUp<ComputerImpl>() {
            @Mock
            public int selectSymbol(String selections) {
                return 0;
            }
        };

        new MockUp<GameManager>() {
            @Mock
            private boolean playAgain() {
                return false;
            }
        };

        gameManager.playGame();
    }

    @Test
    public void playGameWithUserWinnerTest() {
        new MockUp<HumanImpl>() {
            @Mock
            public int selectSymbol(String selections) {
                return 2;
            }
        };

        new MockUp<ComputerImpl>() {
            @Mock
            public int selectSymbol(String selections) {
                return 1;
            }
        };

        new MockUp<GameManager>() {
            @Mock
            private boolean playAgain() {
                return false;
            }
        };

        gameManager.playGame();
    }

    @Test
    public void playGameWithComputerWinnerTest() {
        new MockUp<HumanImpl>() {
            @Mock
            public int selectSymbol(String selections) {
                return 2;
            }
        };

        new MockUp<ComputerImpl>() {
            @Mock
            public int selectSymbol(String selections) {
                return 0;
            }
        };

        new MockUp<GameManager>() {
            @Mock
            private boolean playAgain() {
                return false;
            }
        };

        gameManager.playGame();
    }

    @Test
    public void playGameAgainTest() {
        new MockUp<HumanImpl>() {
            @Mock
            public int selectSymbol(String selections) {
                return 0;
            }
        };

        new MockUp<ComputerImpl>() {
            @Mock
            public int selectSymbol(String selections) {
                return 2;
            }
        };

        new MockUp<GameManager>() {
            @Mock
            private boolean playAgain() {
                counter++;
                return counter < 2;
            }
        };

        gameManager.playGame();
    }
}
