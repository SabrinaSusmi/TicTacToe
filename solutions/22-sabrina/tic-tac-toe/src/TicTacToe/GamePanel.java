package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    public JButton button[][] = new JButton[3][3];
    BoardDecoration boardDecoration = new BoardDecoration();

    public void setButton(JButton button[][]){
        this.button=button;
    }

    public JPanel drawBoardGrid(JPanel panel){

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                panel.add(button[i][j]);
            }
        }

        return panel;
    }
}
