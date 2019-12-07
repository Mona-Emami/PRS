package com.imc.game.strategies;

import com.imc.game.enums.PlayerSelection;

import java.util.Random;

/**
 * This class is the implementation of the GameStrategy interface with using the random strategy.
 */
public class RandomStrategyImpl implements GameStrategy {
    private Random random = new Random(System.currentTimeMillis());

    /**
     * This method get the random Integer number in the range of zero up to PlayerSelectionsCount,
     * And then returns it as the index of the computer selection.
     *
     * @return the index of the computer selection.
     */
    @Override
    public int getComputerSelection() {
        return random.nextInt(PlayerSelection.getPlayerSelectionsCount());
    }
}
