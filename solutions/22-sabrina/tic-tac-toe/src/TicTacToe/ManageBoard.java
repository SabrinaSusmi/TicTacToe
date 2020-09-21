package TicTacToe;

import javax.swing.*;

public class ManageBoard {
    public void refreshBoard(JButton[][] buttons, String[][] moveString){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setIcon(null);
                moveString[i][j]="";
            }
        }
    }
    public void isBoardUnlocked(JButton[][] buttons, boolean lock){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(lock);
            }
        }
    }

}
