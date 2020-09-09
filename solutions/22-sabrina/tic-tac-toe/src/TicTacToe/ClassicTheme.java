package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements Theme{
    private JPanel panel;
    private JButton button[][] = new JButton[3][3];

    @Override
    public void getButton(JButton button[][]){
        this.button=button;
    }

    @Override
    public void drawTheme() {
        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                button[i][j].setBackground(Color.WHITE);
                button[i][j].setBorder(BorderFactory.createLineBorder(Color.black,2));
            }
        }

    }
}
