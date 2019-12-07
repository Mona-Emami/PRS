package com.imc.game.enums;

public enum GameResult {
    YOU_WON("You Won!"),
    COMPUTER_WON("Computer won!"),
    TIE("Tie!"),
    GAME_FINISHED("Game finished!"),
    TOTAL_ROUNDS("Total rounds: "),
    HUMAN_WON_ROUNDS("Rounds you won: "),
    COMPUTER_WON_ROUNDS("Rounds computer won: "),
    ;

    private String value;

    GameResult(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
