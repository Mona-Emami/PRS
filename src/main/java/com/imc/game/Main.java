package com.imc.game;

import com.imc.game.business.GameManager;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is the main class of the application.
 */
public class Main {
    /**
     * This method starts the game with initializing the {@code gameManager} and invoking the {@code playGame()} method.
     */
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.playGame();
    }
}
