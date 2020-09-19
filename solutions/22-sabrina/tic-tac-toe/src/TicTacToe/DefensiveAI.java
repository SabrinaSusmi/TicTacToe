package TicTacToe;

import javax.swing.*;
import java.util.Random;

public class DefensiveAI implements AI{
    DefensiveMoveChecker defensiveMoveChecker;
    RandomAI randomAI = new RandomAI();

    @Override

    public void move(JButton[][] button, String[][] moveString){
        defensiveMoveChecker = new DefensiveMoveChecker(moveString);
        if(defensiveMoveChecker.canBeDefended()){
            defensiveMoveChecker.checkDefenseRow();
            defensiveMoveChecker.checkDefenseColumn();
            defensiveMoveChecker.checkDefenseFirstDiagonal();
            defensiveMoveChecker.checkDefenseSecondDiagonal();
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    if(moveString[i][j].equals("defend")){
                        button[i][j].setText("o");
                        moveString[i][j]="o";
                    }
                }
            }
        }
        else {
            randomAI.move(button,moveString);
        }
    }
}
