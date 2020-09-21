package TicTacToe.AI;

import TicTacToe.Theme.SelectTheme;
import TicTacToe.Theme.Theme;

import javax.swing.*;

public class DefensiveAI implements AI{
    DefensiveMoveChecker defensiveMoveChecker;
    RandomAI randomAI;
    Theme theme;
    SelectTheme selectTheme;

    public DefensiveAI(SelectTheme selectTheme) {
        this.selectTheme = selectTheme;
        randomAI = new RandomAI(selectTheme);
    }

    @Override

    public void move(JButton[][] button, String[][] moveString){
        theme = selectTheme.getTheme();
        defensiveMoveChecker = new DefensiveMoveChecker(moveString);
        if(defensiveMoveChecker.canBeDefended()){
            for(int row=0; row<3; row++){
                for(int col=0; col<3; col++){
                    if(moveString[row][col].equals("defend")){
                        button[row][col].setIcon(theme.getAIIcon());
                        moveString[row][col]="o";
                        break;
                    }
                }
            }
        }
        else {
            randomAI.move(button,moveString);
        }
    }
}
