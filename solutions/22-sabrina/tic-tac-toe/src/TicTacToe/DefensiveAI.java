package TicTacToe;

import javax.swing.*;
import java.util.Random;

public class DefensiveAI implements AI{
    RandomAI randomAI = new RandomAI();

    @Override
    public void move(JButton[][] button, String[][] moveString) {
        if(moveString[0][0]==moveString[1][1] && moveString[1][1]=="x" && moveString[2][2]==""){
            button[2][2].setText("o");
            moveString[2][2]="o";
        }
        else if(moveString[2][2]==moveString[1][1] && moveString[1][1]=="x" && moveString[0][0]==""){
            button[0][0].setText("o");
            moveString[0][0]="o";
        }
        else if(moveString[0][2]==moveString[1][1] && moveString[1][1]=="x" && moveString[2][0]==""){
            button[2][0].setText("o");
            moveString[2][0]="o";
        }
        else if(moveString[2][0]==moveString[1][1] && moveString[1][1]=="x" && moveString[0][2]==""){
            button[0][2].setText("o");
            moveString[0][2]="o";
        }
        else{
            for(int i=0; i<3; i++) {
                if (moveString[i][0] == moveString[i][1] && moveString[i][0] == "x" && moveString[i][2]=="") {
                    button[i][2].setText("o");
                    moveString[i][2] = "o";
                    break;
                } else if (moveString[i][1] == moveString[i][2] && moveString[i][1] == "x" && moveString[i][0]=="") {
                    button[i][0].setText("o");
                    moveString[i][0] = "o";
                    break;
                } else if (moveString[0][i] == moveString[1][i] && moveString[0][i] == "x" && moveString[2][i]=="") {
                    button[2][i].setText("o");
                    moveString[2][i] = "o";
                    break;
                } else if (moveString[1][i] == moveString[2][i] && moveString[1][i] == "x" && moveString[0][i]=="") {
                    button[0][i].setText("o");
                    moveString[0][i] = "o";
                    break;
                } else {
                    randomAI.move(button,moveString);
                    break;
                }
            }
        }

    }
}
