package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];

    public ClassicTheme(JPanel panel) {
        this.panel = panel;
        //drawClassicTheme();
    }

    public JPanel drawClassicTheme() {

        panel.setLayout(new GridLayout(3,3));


        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            button[i].setBackground(Color.WHITE);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
            panel.add(button[i]);
        }

        return panel;
    }
}
