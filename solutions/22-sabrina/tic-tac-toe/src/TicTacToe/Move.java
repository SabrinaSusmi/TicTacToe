package TicTacToe;

import TicTacToe.AI.AI;
import TicTacToe.Theme.SelectTheme;
import TicTacToe.Theme.Theme;

import javax.swing.*;

public class Move {
    Theme theme;
    SelectTheme selectTheme;

    public Move(SelectTheme selectTheme) {
        this.selectTheme=selectTheme;
    }

    void setPlayerMove(JButton button){
        theme = selectTheme.getTheme();
        button.setIcon(theme.getPlayerIcon());
    }

    void setComputerMove(AI ai, JButton[][] button, String[][] buttonKeyTracker){
        ai.move(button,buttonKeyTracker);
    }
}
