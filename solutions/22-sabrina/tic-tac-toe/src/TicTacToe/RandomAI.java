package TicTacToe;

import javax.swing.*;
import java.util.Random;

public class RandomAI implements AI{
    Theme theme;
    SelectTheme selectTheme;

    public RandomAI(SelectTheme selectTheme) {
        this.selectTheme = selectTheme;
    }

    @Override
    public void move(JButton[][] button, String[][] moveString) {
        theme = selectTheme.getTheme();
        int row = new Random().nextInt(3);
        int col = new Random().nextInt(3);
        while(true){
            if(moveString[row][col]!=""){
                row = new Random().nextInt(3);
                col = new Random().nextInt(3);
            }
            else
                break;
        }
        button[row][col].setIcon(theme.getAIIcon());
        moveString[row][col]="o";
    }
}
