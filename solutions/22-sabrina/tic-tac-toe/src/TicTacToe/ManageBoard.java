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
    public void lockBoard(JButton[][] buttons){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(false);
            }
        }
    }

    public void unlockBoard(JButton[][] buttons){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setEnabled(true);
            }
        }
    }

}
