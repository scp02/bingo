package controller;

import model.BingoCard;
import view.NumberFrame;
import view.PlayerFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Stack;

public class BingoGameController implements ActionListener {
    private Stack<Integer> drawNumberList = new Stack<>();

    private PlayerFrame player1Frame = new PlayerFrame();
    private PlayerFrame player2Frame = new PlayerFrame();

    private NumberFrame numberFrame = new NumberFrame();

    private BingoCard player1Card = new BingoCard();
    private BingoCard player2Card = new BingoCard();

    public BingoGameController() {
        player1Frame.setBounds(0, 0, 600, 600);
        player2Frame.setBounds(840, 0, 600, 600);

        addCardNumbers(player1Card, player1Frame);
        addCardNumbers(player2Card, player2Frame);

        for (int i = 1; i <= 75; i++)
            drawNumberList.add(i);

        Collections.shuffle(drawNumberList);
        numberFrame.getNextNumberButton().addActionListener(this);

        player1Frame.setTitle("Player 1");
        player2Frame.setTitle("Player 2");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (drawNumberList.size() > 0) {
            // draw the next number
            int number = drawNumberList.pop();
            numberFrame.getNextNumberButton().setText(Integer.toString(number));

            // check if any player wins
            boolean is1Winner = checkBoard(number, player1Frame, player1Card);
            boolean is2Winner = checkBoard(number, player2Frame, player2Card);

            // display messages as per which players won
            if (is1Winner && is2Winner) {
                JOptionPane.showMessageDialog(numberFrame, "Good job to both players!");
                endGame();
            }
            else if (is1Winner) {
                JOptionPane.showMessageDialog(numberFrame, "Player 1 wins! Congratulations!");
                endGame();
            }
            else if (is2Winner) {
                JOptionPane.showMessageDialog(numberFrame, "Player 2 wins! Congratulations!");
                endGame();
            }

        }
        // otherwise, all the cards have been drawn and the game ends
        else {
            JOptionPane.showMessageDialog(numberFrame, "Game over!!");
        }
    }

    // remove all frames and quit
    private void endGame() {
        player1Frame.dispose();
        player2Frame.dispose();
        numberFrame.dispose();
    }

    // display each players' cards on their window
    private void addCardNumbers (BingoCard card, PlayerFrame frame) {
        for (int row = 0; row < card.getGrid().length; row++)
            for (int column = 0; column < card.getGrid()[row].length; column++)
                frame.getCardPanel().getNumberJLabelArray()[row][column].setText(Integer.toString(card.getGrid()[row][column]));
    }

    // check if a given card exists on a player's bingo card
    private boolean checkBoard (int number, PlayerFrame frame, BingoCard card) {
        for (int row = 0; row < card.getGrid().length; row++) {
            for (int column = 0; column < card.getGrid()[row].length; column++) {
                if (card.getGrid()[row][column] == number) {
                    // highlight the number green
                    frame.getCardPanel().getNumberJLabelArray()[row][column].setBackground(Color.green);
                    card.getGrid()[row][column] = 0;

                    if (card.checkBingo())
                        return true;
                }
            }
        }
        return false;
    }
}
