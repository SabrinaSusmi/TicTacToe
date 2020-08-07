package TicTacToe;

import javax.swing.*;
import java.util.Random;

public class RandomAI {
    public void randomMove(JButton button[]){
        int index = new Random().nextInt(9);
        while(true){
            if(button[index].getText()!=""){
                index = new Random().nextInt(9);
            }
            else
                break;
        }
        button[index].setText("O");
    }
}
