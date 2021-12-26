package view;

import javax.swing.*;
import java.awt.*;

public class NumberFrame extends JFrame {
    private JLabel instructionLbl = new JLabel("Click on button below:");
    private JButton nextNumberButton = new JButton("0");

    public NumberFrame() {
        nextNumberButton.setText("0");
        setBackground(Color.red);
        setLayout(null);

        setTitle("Bingo! Host Screen");

        setBounds(600,0, 240, 600);

        instructionLbl.setFont(new Font("Helvetica", Font.BOLD, 22));
        instructionLbl.setBounds(4,0, 240, 36);

        nextNumberButton.setBounds(0,34, 240, 538);
        nextNumberButton.setFont(new Font("Helvetica", Font.BOLD, 44));
        nextNumberButton.setForeground(Color.red);

        add(instructionLbl);
        add(nextNumberButton);

        setBackground(Color.red);

        setVisible(true);
    }

    public JLabel getInstructionLbl() {
        return instructionLbl;
    }

    public void setInstructionLbl(JLabel instructionLbl) {
        this.instructionLbl = instructionLbl;
    }

    public JButton getNextNumberButton() {
        return nextNumberButton;
    }

    public void setNextNumberButton(JButton nextNumberButton) {
        this.nextNumberButton = nextNumberButton;
    }
}
