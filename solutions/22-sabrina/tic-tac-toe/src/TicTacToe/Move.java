package TicTacToe;

import javax.swing.*;

public class Move {
    SelectAI selectAI = new SelectAI();
    //AI ai;
    //RandomAI randomAI = new RandomAI();
    void setPlayerMove(JButton button){
        button.setText("x");
    }

    void setComputerMove(AI ai, JButton[][] button, String[][] moveString){
        //ai = selectAI.getAi();
        ai.move(button,moveString);
    }
}
