package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements Theme{
    private JPanel panel;
    private JButton button[][] = new JButton[3][3];
    BoardDecoration boardDecoration = new BoardDecoration();

    @Override
    public void getButton(JButton button[][]){
        this.button=button;
    }

    public Color getBackgroundColor(){
        return boardDecoration.classicBoardColor;
    }

    public Color getBorderColor(){
        return boardDecoration.classicBorderColor;
    }

    @Override
    public void drawTheme() {
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                button[i][j].setBackground(boardDecoration.classicBoardColor);
                button[i][j].setBorder(BorderFactory.createLineBorder(boardDecoration.classicBorderColor,2));
            }
        }

    }
}
