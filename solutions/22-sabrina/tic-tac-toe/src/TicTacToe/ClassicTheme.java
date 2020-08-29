package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements Theme{
    private JPanel panel;
    private JButton button[]= new JButton[9];
    GamePanel gamePanel = new GamePanel();

    @Override
    public void drawTheme() {
        //button = boardButtons.drawButton(button);
        button = gamePanel.button;
        for (int i=0; i<9; i++){
            button[i].setBackground(Color.WHITE);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
        }
        PlayerMove playerMove = new PlayerMove(button,panel);
        playerMove.playerMove();

    }
}
