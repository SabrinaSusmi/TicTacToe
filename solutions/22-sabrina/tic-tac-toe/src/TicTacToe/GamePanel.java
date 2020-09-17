package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JButton[][] button;
    private JPanel panel;
    BoardDecoration boardDecoration = new BoardDecoration();

    public GamePanel(JButton button[][], JPanel panel){
        this.button=button;
        this.panel=panel;
    }

    public JPanel drawBoardGrid(){

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j] = new JButton();
                button[i][j].setFont(boardDecoration.boardFont);
                panel.add(button[i][j]);
            }
        }

        return panel;
    }
}
