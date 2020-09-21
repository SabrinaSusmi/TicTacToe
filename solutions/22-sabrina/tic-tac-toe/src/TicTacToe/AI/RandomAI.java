package TicTacToe.AI;

import TicTacToe.Theme.SelectTheme;
import TicTacToe.Theme.Theme;

import javax.swing.*;
import java.util.Random;

public class RandomAI implements AI{
    Theme theme;
    SelectTheme selectTheme;

    public RandomAI(SelectTheme selectTheme) {
        this.selectTheme = selectTheme;
    }

    @Override
    public void move(JButton[][] buttonArray, String[][] buttonKeyTracker) {
        theme = selectTheme.getTheme();
        int row = new Random().nextInt(3);
        int col = new Random().nextInt(3);
        while(true){
            if(buttonKeyTracker[row][col]!=""){
                row = new Random().nextInt(3);
                col = new Random().nextInt(3);
            }
            else
                break;
        }
        buttonArray[row][col].setIcon(theme.getAIIcon());
        buttonKeyTracker[row][col]="o";
    }
}
