package TicTacToe;

import javax.swing.*;
import java.util.Random;

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
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(moveString[i][j].equals("defend")){
                        button[i][j].setIcon(theme.getAIIcon());
                        moveString[i][j]="o";
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
