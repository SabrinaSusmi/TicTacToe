package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JPanel panel;
    public JButton button[][] = new JButton[3][3];
    String moveString[][]= new String[3][3];

//    public void setButton(JButton button[][]){
//        this.button=button;
//    }

    public JPanel drawBoardGrid(JPanel panel){
        this.panel = panel;

        BoardButtons boardButtons = new BoardButtons();
        button=boardButtons.drawButton();

        ButtonPanel buttonPanel = new ButtonPanel();
        buttonPanel.setButton(button,moveString);

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                panel.add(button[i][j]);
            }
        }

        return panel;
    }
}
