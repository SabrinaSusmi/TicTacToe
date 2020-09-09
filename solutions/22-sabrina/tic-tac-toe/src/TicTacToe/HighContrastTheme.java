package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class HighContrastTheme implements Theme{
    private JPanel panel;
    private JButton button[][] = new JButton[3][3];

    @Override
    public void getButton(JButton button[][]) {
        this.button=button;
    }

    @Override
    public void drawTheme() {
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBackground(new Color(0x69696f));
                button[i][j].setBorder(BorderFactory.createLineBorder(new Color(0xc0c0c0), 2));
            }
        }
    }

}
