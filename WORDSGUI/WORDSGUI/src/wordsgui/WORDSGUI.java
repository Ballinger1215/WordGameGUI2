/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordsgui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author bjozeabbaschian
 */
public class WORDSGUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new GUIContent();
    }
}

class GUIContent extends JFrame {

    private JButton playBtn, scoreBtn, wordBtn, exitBtn;
    private JPanel mainMenupanel, pnl;
    private JTextField uNField, pWField;
    String[] pNames;
    int[] scores;
    int playerCounter = 0;

    public GUIContent() {
        pNames = new String[2];
        scores = new int[2];
        mainMenu();
    }

    private void mainMenu() {
        mainMenupanel = new JPanel();
        playBtn = new JButton("Play");
        scoreBtn = new JButton("Show Score");
        wordBtn = new JButton("Add Words");
        exitBtn = new JButton("Exit");
        playBtn.addActionListener(new Buttons());
        scoreBtn.addActionListener(new Buttons());
        wordBtn.addActionListener(new Buttons());
        exitBtn.addActionListener(new Buttons());
        mainMenupanel.setLayout(new GridLayout(4, 0, 10, 10));
        mainMenupanel.add(playBtn);
        mainMenupanel.add(scoreBtn);
        mainMenupanel.add(wordBtn);
        mainMenupanel.add(exitBtn);
        pnl = new JPanel();
        pnl.add(mainMenupanel);
        add(pnl);
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void gameController() {
        userLogin();

    }

    private void userLogin() {
        uNField = new JTextField(20);
        pWField = new JPasswordField(20);
        mainMenupanel = new JPanel();
        playBtn = new JButton("Signin/up");
        playBtn.addActionListener(new gameBtns());
        mainMenupanel.setLayout(new GridLayout(3, 0, 10, 10));
        mainMenupanel.add(uNField);
        mainMenupanel.add(pWField);
        mainMenupanel.add(playBtn);
        pnl = new JPanel();
        pnl.add(mainMenupanel);
        add(pnl);
        repaint();
        setVisible(true);

    }

    private class gameBtns implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playBtn) {
                remove(pnl);
                setVisible(false);
                pNames[playerCounter] = uNField.getText();

                if (playerCounter == 0) {
                    playerCounter++;
                    userLogin();
                } else {
                    Game gamePanel = new Game(pNames, scores);
                    add(gamePanel);
                    repaint();
                    setVisible(true);
                }

            }
        }
    }

    private class Buttons implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == playBtn) {
                remove(pnl);
                setVisible(false);

                gameController();
            }
            if (e.getSource() == scoreBtn) {

            }
            if (e.getSource() == wordBtn) {

            }
            if (e.getSource() == exitBtn) {

            }
            //    JOptionPane.showMessageDialog(null, "yahoo");

        }
    }
}
