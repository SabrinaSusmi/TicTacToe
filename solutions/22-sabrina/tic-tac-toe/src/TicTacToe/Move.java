package TicTacToe;

import javax.swing.*;

public class Move {
    Theme theme;
    SelectTheme selectTheme;

    public Move(SelectTheme selectTheme) {
        this.selectTheme=selectTheme;
    }

    void setPlayerMove(JButton button){
        button.setText("x");
        selectTheme.getTheme();
    }

    void setComputerMove(AI ai, JButton[][] button, String[][] moveString){
        //ai = selectAI.getAi();
        ai.move(button,moveString);
    }
}
