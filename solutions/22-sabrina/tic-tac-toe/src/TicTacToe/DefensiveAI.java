package TicTacToe;

import javax.swing.*;

public class DefensiveAI {
    private int flag=0;

    public boolean firstMove(JButton button[]) {
        for(JButton b : button) {
            if(b.getText()!=""){
                flag =1;
            }
        }

        if(flag==0)
            return true;
        else
            return false;
    }
}
