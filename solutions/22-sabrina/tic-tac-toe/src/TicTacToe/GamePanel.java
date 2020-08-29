package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JPanel panel;
    public JButton button[] = new JButton[9];
    BoardButtons boardButtons = new BoardButtons();

    public JPanel drawBoardGrid(JPanel panel){
        this.panel = panel;

        panel.setLayout(new GridLayout(3,3));
        button = boardButtons.drawButton(button);
        for(int i=0; i<9; i++){
            panel.add(button[i]);
        }

        return panel;
    }
}
