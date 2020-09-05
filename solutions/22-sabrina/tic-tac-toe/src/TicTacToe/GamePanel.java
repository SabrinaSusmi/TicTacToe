package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JPanel panel;
    public JButton button[] = new JButton[9];

    public void getButton(JButton button[]){
        this.button=button;
    }

    public JPanel drawBoardGrid(JPanel panel){
        this.panel = panel;

        panel.setLayout(new GridLayout(3,3));
        for(int i=0; i<9; i++){
            panel.add(button[i]);
        }

        return panel;
    }
}
