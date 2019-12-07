package com.imc.game.business;

import com.imc.game.enums.GameResult;
import com.imc.game.enums.PlayerSelection;
import com.imc.game.players.ComputerImpl;
import com.imc.game.players.HumanImpl;
import com.imc.game.players.Player;
import com.imc.game.strategies.GameStrategy;
import com.imc.game.strategies.RandomStrategyImpl;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The main logic of the game is implemented in this class
 */
public class GameManager {
    private Logger logger = Logger.getLogger(GameManager.class);
    private GameStrategy gameStrategy = new RandomStrategyImpl();
    private Player computerPlayer = new ComputerImpl(gameStrategy);
    private Player humanPlayer = new HumanImpl();
    private int totalRounds = 0;
    private int humanWonRounds = 0;
    private int computerWonRounds = 0;

    /**
     * This method can be run N times before exit.
     * In each time, the method at first, creates the appropriate {@code selections} by iterating the PlayerSelection,
     * and asks the user to select one of the symbols and then computer selects a symbol randomly,
     * then get the index of the user {@code humanInput} and computer selection {@code computerInput}
     * and finds a winner by using a simple and extensive algorithm.
     * This method also calculates and shows the total played rounds number, the rounds number which user won and the the rounds number which computer won.
     * And at the end, asks if the user wants to play again and continues or finishes the game accordingly.
     */
    public void playGame() {
        String selections = createPlayerSelections();

        while (true) {
            int humanInput = humanPlayer.selectSymbol(selections);
            int computerInput = computerPlayer.selectSymbol(null);
            findWinner(humanInput, computerInput);
            logger.info(GameResult.TOTAL_ROUNDS.getValue() + ++totalRounds);
            logger.info(GameResult.HUMAN_WON_ROUNDS.getValue() + humanWonRounds);
            logger.info(GameResult.COMPUTER_WON_ROUNDS.getValue() + computerWonRounds);

            if (!playAgain()) {
                logger.info(GameResult.GAME_FINISHED.getValue());
                break;
            }
        }
    }

    private String createPlayerSelections() {
        String text = "Select ";
        List<String> selections = IntStream.range(0, PlayerSelection.getPlayerSelectionsCount())
                .filter(i -> PlayerSelection.getByIndex(i) != null)
                .mapToObj(i -> PlayerSelection.getByIndex(i).name())
                .collect(Collectors.toList());

        text += String.join(" or ", selections) + ":";
        return text;
    }

    private void findWinner(int humanInput, int computerInput) {
        if (humanInput == computerInput) {
            logger.info(GameResult.TIE.getValue());
        } else {
            int symbolsCount = PlayerSelection.getPlayerSelectionsCount();
            int result = (symbolsCount + (humanInput - computerInput)) % symbolsCount;

            if (result % 2 == 1) {
                humanWonRounds++;
                logger.info(GameResult.YOU_WON.getValue());
            } else {
                computerWonRounds++;
                logger.info(GameResult.COMPUTER_WON.getValue());
            }
        }
    }

    private boolean playAgain() {
        Scanner scanner = new Scanner(System.in);
        logger.info("Do you want to play again [(Y)es/Any-other-key]? ");
        return scanner.next().toLowerCase().startsWith("y");
    }
}
