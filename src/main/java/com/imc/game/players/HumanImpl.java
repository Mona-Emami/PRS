package com.imc.game.players;

import com.imc.game.enums.PlayerSelection;
import org.apache.log4j.Logger;

import java.util.Scanner;

/**
 * This class is the implementation of the Player interface for the human.
 */
public class HumanImpl implements Player {
    private Logger logger = Logger.getLogger(HumanImpl.class);
    private Scanner scanner = new Scanner(System.in);

    /**
     * This method shows the user symbols (ROCK PAPER SCISSORS) and asks them to select one.
     * Also checks the user selection and asks the user to select again if the selected symbol {@code playerSelection} was invalid,
     * and continues this process until the user selects a valid symbol.
     * then shows the user what has been selected.
     * And then returns the index of the selected symbol.
     *
     * @return the index of the selected symbol by the user.
     */
    @Override
    public int selectSymbol(String selections) {
        logger.info(selections);
        PlayerSelection playerSelection;

        while ((playerSelection = PlayerSelection.getBySelection(scanner.next())) == null) {
            logger.info("Your selection is invalid..");
            logger.info(selections);
        }

        logger.info("Your selection is: " + playerSelection);
        return playerSelection.getIndex();
    }
}
