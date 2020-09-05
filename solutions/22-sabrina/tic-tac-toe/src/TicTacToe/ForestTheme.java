package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ForestTheme implements Theme{
    private JPanel panel;
    private JButton button[] = new JButton[9];

    @Override
    public void getButton(JButton button[]){
        this.button=button;
    }

    @Override
    public void drawTheme() {
        for (int i=0; i<9; i++){
            button[i].setBackground(new Color(0x00ff00));
            button[i].setBorder(BorderFactory.createLineBorder(new Color(0x056608),2));
        }
    }
}
