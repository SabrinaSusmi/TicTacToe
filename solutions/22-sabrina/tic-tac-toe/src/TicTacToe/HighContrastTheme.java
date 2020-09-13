package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class HighContrastTheme implements Theme{
    private JPanel panel;
    private JButton button[][] = new JButton[3][3];
    BoardDecoration boardDecoration = new BoardDecoration();

    @Override
    public void getButton(JButton button[][]) {
        this.button=button;
    }

    @Override
    public void drawTheme() {
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setBorder(BorderFactory.createLineBorder(boardDecoration.highContrastBorderColor, 2));
                if(button[i][j].getText()=="x"){
                    button[i][j].setBackground(Color.black);
                    button[i][j].setForeground(Color.WHITE);
                }
                else if(button[i][j].getText()=="o"){
                    button[i][j].setBackground(Color.white);
                    button[i][j].setForeground(Color.black);
                }
                else{
                    button[i][j].setBackground(boardDecoration.highContrastBoardColor);
                }
            }
        }
    }

}
