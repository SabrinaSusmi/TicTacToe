package TicTacToe;

import javax.swing.*;

public class ManageBoard {
    public void refreshBoard(JButton[][] buttons, String[][] moveString){
        for (int row=0; row<3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setIcon(null);
                moveString[row][col]="";
            }
        }
    }
    public void isBoardUnlocked(JButton[][] buttons, boolean lock){
        for (int row=0; row<3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setEnabled(lock);
            }
        }
    }

}
