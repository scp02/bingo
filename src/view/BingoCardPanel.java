package view;

import javax.swing.*;
import java.awt.*;

public class BingoCardPanel extends JPanel {
    private JLabel cardLabel = new JLabel(new ImageIcon("bingoCard.png"));
    private JLabel[][] numberJLabelArray = new JLabel[5][5];

    public BingoCardPanel() {
        setLayout(null);
        cardLabel.setLayout(null);
        addNumberLabels();

        cardLabel.setBounds(0, 0, 600, 600);
        add(cardLabel);
    }

    public JLabel getCardLabel() {
        return cardLabel;
    }

    public void setCardLabel(JLabel cardLabel) {
        this.cardLabel = cardLabel;
    }

    public JLabel[][] getNumberJLabelArray() {
        return numberJLabelArray;
    }

    public void setNumberJLabelArray(JLabel[][] numberJLabelArray) {
        this.numberJLabelArray = numberJLabelArray;
    }

    private void addNumberLabels () {
        for (int row = 0; row < numberJLabelArray.length; row++) {
            for (int column = 0; column < numberJLabelArray[row].length; column++) {
                numberJLabelArray[row][column] = new JLabel();
                numberJLabelArray[row][column].setFont(new Font("Serif", Font.BOLD, 36));
                numberJLabelArray[row][column].setOpaque(true);
                numberJLabelArray[row][column].setBackground(Color.white);

                if (row == 2 && column == 2) {
                    numberJLabelArray[row][column].setBackground(Color.green);
                    numberJLabelArray[row][column].setText("  X  ");
                    numberJLabelArray[row][column].setFont(new Font("Serif", Font.BOLD, 36));
                }

                numberJLabelArray[row][column].setBounds(85 + column * 100, 75 + row * 100, 50, 50);
                cardLabel.add(numberJLabelArray[row][column]);
            }
        }
    }

}
