package TicTacToe;

import javax.swing.*;
import java.util.Random;

public class RandomAI implements AI{
    @Override
    public void move(JButton button[][]) {
        int row = new Random().nextInt(3);
        int col = new Random().nextInt(3);
        while(true){
            if(button[row][col].getText()!=""){
                row = new Random().nextInt(3);
                col = new Random().nextInt(3);
            }
            else
                break;
        }
        button[row][col].setText("O");
    }
}
