package TicTacToe;

import javax.swing.*;

public class GamePlay {
    void setPlayerMove(JButton button){
        button.setText("x");
    }

    void setComputerMove(AI ai, JButton[][] button, String[][] moveString){
        ai.move(button,moveString);
    }
}
