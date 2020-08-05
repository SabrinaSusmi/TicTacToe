package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ForestTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];

    public ForestTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawForestTheme() {

        panel.setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            button[i].setBackground(new Color(0x00ff00));
            button[i].setBorder(BorderFactory.createLineBorder(new Color(0x056608),2));
            panel.add(button[i]);
        }

        return panel;
    }
}
