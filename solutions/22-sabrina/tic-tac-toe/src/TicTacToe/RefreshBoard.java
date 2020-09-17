package TicTacToe;

import javax.swing.*;

public class RefreshBoard {
    public void refreshBoard(JButton[][] buttons, String[][] moveString){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
                moveString[i][j]="";
            }
        }
    }
}
