package com.imc.game.players;

import com.imc.game.enums.PlayerSelection;
import com.imc.game.strategies.GameStrategy;
import org.apache.log4j.Logger;

/**
 * This class is the implementation of the Player interface for the computer.
 */
public class ComputerImpl implements Player {
    private Logger logger = Logger.getLogger(ComputerImpl.class);
    private final GameStrategy gameStrategy;

    public ComputerImpl(GameStrategy gameStrategy) {
        this.gameStrategy = gameStrategy;
    }

    /**
     * This method get the computer selection by generating it's index with random strategy and shows the selected symbol to the user,
     * then returns the index.
     *
     * @return the index {@code computerInput} of the selected symbol
     */
    @Override
    public int selectSymbol(String selections) {
        int computerInput = gameStrategy.getComputerSelection();
        logger.info("Computer selection is: " + PlayerSelection.getByIndex(computerInput));
        return computerInput;
    }
}