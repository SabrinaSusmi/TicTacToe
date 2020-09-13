package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ForestTheme implements Theme{
    private JPanel panel;
    private JButton button[][] = new JButton[3][3];
    BoardDecoration boardDecoration = new BoardDecoration();

    @Override
    public void getButton(JButton button[][]){
        this.button=button;
    }

    @Override
    public void drawTheme() {
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBackground(boardDecoration.forestBoardColor);
                button[i][j].setBorder(BorderFactory.createLineBorder(boardDecoration.forestBorderColor, 2));
            }
        }
    }
}
