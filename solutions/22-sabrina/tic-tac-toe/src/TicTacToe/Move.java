package TicTacToe;

import javax.swing.*;

public class Move {
    Theme theme;
    SelectTheme selectTheme;

    public Move(SelectTheme selectTheme) {
        this.selectTheme=selectTheme;
    }

    void setPlayerMove(JButton button){
        //button.setText("x");
        //theme = selectTheme.getTheme();
        //button.setText(theme.getPlayerIcon());
        ClassicTheme classicTheme = new ClassicTheme();
        button.setIcon(classicTheme.getPlayersIcon());
    }

    void setComputerMove(AI ai, JButton[][] button, String[][] moveString){
        //ai = selectAI.getAi();
        ai.move(button,moveString);
    }
}
