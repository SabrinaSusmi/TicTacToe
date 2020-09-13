package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class BoardButtons {
    private JButton button[][] = new JButton[3][3];
    BoardDecoration boardDecoration = new BoardDecoration();

    public JButton[][] drawButton() {
        for (int i=0; i<3; i++) {
            for(int j=0; j<3; j++){
                button[i][j] = new JButton();
                button[i][j].setFont(boardDecoration.boardFont);
            }
        }
        return button;
    }
}
