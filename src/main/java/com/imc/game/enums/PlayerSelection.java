package com.imc.game.enums;

import java.util.Arrays;

/**
 * All required actions about player selections is implemented in this class.
 * Also it is worth mentioning that just by adding SPOCK(3, "spock") and LIZARD(4, "lizard") to the below selections, the game can be extended to SPOCK/LIZARD version.
 */
public enum PlayerSelection {
    ROCK(0, "rock"),
    PAPER(1, "paper"),
    SCISSORS(2, "scissors"),
    ;

    private int index;
    private String selection;

    PlayerSelection(int index, String selection) {
        this.index = index;
        this.selection = selection;
    }

    public int getIndex() {
        return index;
    }

    public String getSelection() {
        return selection;
    }

    /**
     * This method receives the {@code index} and returns the {@code PlayerSelection} which is mapped to the given index
     * or returns null if there is not any mapped selection to the given index.
     *
     * @param index the index of the player selection
     * @return null or the {@code PlayerSelection} which is mapped to the given index
     */
    public static PlayerSelection getByIndex(int index) {
        return Arrays.stream(values()).filter(s -> s.getIndex() == index).findFirst().orElse(null);
    }

    /**
     * This method receives the {@code selection} and returns the {@code PlayerSelection} which is mapped to the given selection
     * or returns null if there is not any mapped PlayerSelection to the given selection which it means that the given selection is invalid.
     *
     * @param selection the selection of the player
     * @return null or the {@code PlayerSelection} which is mapped to the given selection
     */
    public static PlayerSelection getBySelection(String selection) {
        if (selection == null)
            return null;

        return Arrays.stream(values()).filter(s -> s.getSelection().equalsIgnoreCase(selection)).findFirst().orElse(null);
    }

    /**
     * @return the player selections count
     */
    public static int getPlayerSelectionsCount() {
        return PlayerSelection.values().length;
    }
}