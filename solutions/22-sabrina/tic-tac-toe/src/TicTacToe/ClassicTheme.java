package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements Theme{
    private JPanel panel;
    private JButton button[]= new JButton[9];

    @Override
    public void getButton(JButton button[]){
        this.button=button;
    }

    @Override
    public void drawTheme() {
        for (int i=0; i<9; i++){
            button[i].setBackground(Color.WHITE);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
        }
//        PlayerMove playerMove = new PlayerMove(button,panel);
//        playerMove.playerMove();

    }
}
