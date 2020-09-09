package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JPanel panel;
    public JButton button[][] = new JButton[3][3];

    public void getButton(JButton button[][]){
        this.button=button;
    }

    public JPanel drawBoardGrid(JPanel panel){
        this.panel = panel;

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                panel.add(button[i][j]);
            }
        }
        PlayerMove playerMove = new PlayerMove(button);
        playerMove.playerMove();

        return panel;
    }
}
