/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsgui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

/**
 *
 * @author bjozeabbaschian
 */
public class Game extends JPanel {

    int playerCounter;
    String[] pNames;
    int[] scores;
    JPanel pnl;
    PlayerPane[] player;
    JTextField wordField;

    public Game(String[] pnames, int[] oldscores) {
        pNames = pnames;
        scores = oldscores;
        playerCounter = 0;
        player = new PlayerPane[2];
        player[0] = new PlayerPane(pNames[0]);
        player[1] = new PlayerPane(pNames[1]);
        player[1].playerInput.setEnabled(false);
        JPanel words = new JPanel();

        player[0].playerInput.addKeyListener(new TextListener());
        player[1].playerInput.addKeyListener(new TextListener());

        JTextField wordField = new JTextField("- - - - - - -");
        words.setMinimumSize(new Dimension(100, 100));
        words.add(wordField);

        pnl = new JPanel();
        pnl.setLayout(new BoxLayout(pnl, BoxLayout.X_AXIS));
        pnl.add(player[0]);
        pnl.add(words);
        pnl.add(player[1]);
        add(pnl);

    }

    private class TextListener implements KeyListener {

        private void checkGuess(char text) {
            if (true) {
                player[playerCounter].playerInput.setEnabled(false);
                player[playerCounter].playerGuessList.addElement(text);
                player[playerCounter].playerGuess = new JList(player[playerCounter].playerGuessList);
                wordField.setText("----" + text + "---");
                playerCounter++;
                

                if (playerCounter == 2) {
                    playerCounter = 0;
                }
                player[playerCounter].playerInput.setEnabled(true);

            }

        }

        public void keyTyped(KeyEvent e) {
            System.out.print(e.getKeyChar());
            checkGuess(e.getKeyChar());
        }

        public void keyPressed(KeyEvent e) {
            return;
        }

        public void keyReleased(KeyEvent e) {
            return;
        }
    }

    private class PlayerPane extends JPanel {

        JLabel playerName, playerScore;
        JTextField playerInput;
        JList playerGuess;
        DefaultListModel playerGuessList = new DefaultListModel();

        public PlayerPane(String pName) {
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            playerName = new JLabel(pName);
            playerInput = new JTextField(3);

            playerGuess = new JList(playerGuessList);
            playerScore = new JLabel("SCORE");

            add(playerName);
            add(playerInput);
            add(playerGuess);
            add(playerScore);

        }
    }

}
