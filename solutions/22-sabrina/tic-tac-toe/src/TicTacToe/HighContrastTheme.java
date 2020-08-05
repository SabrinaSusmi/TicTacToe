package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class HighContrastTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];

    public HighContrastTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawHighContrastTheme() {

        panel.setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            button[i].setBackground(new Color(0xc0c0c0));
            button[i].setBorder(BorderFactory.createLineBorder(new Color(0x69696f),2));
            panel.add(button[i]);
        }

        return panel;
    }
}
