package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];
    DefensiveAI defensiveAI = new DefensiveAI();

    public ClassicTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawClassicTheme() {

        panel.setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            button[i].setBackground(Color.WHITE);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
            panel.add(button[i]);
        }
        if(defensiveAI.firstMove(button)){
            button[1].setText("X");
        }

        return panel;
    }
}
