package view;

import javax.swing.*;

public class PlayerFrame extends JFrame {
    private BingoCardPanel cardPanel = new BingoCardPanel();

    public PlayerFrame() {
        this.setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);

        cardPanel.setBounds(0,0, 600, 600);

        add(cardPanel);
        setVisible(true);
    }

    public BingoCardPanel getCardPanel() {
        return cardPanel;
    }

    public void setCardPanel(BingoCardPanel cardPanel) {
        this.cardPanel = cardPanel;
    }
}
