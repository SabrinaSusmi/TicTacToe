package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ForestTheme implements Theme{
    private JPanel panel;
    private JButton button[] = new JButton[9];
    GamePanel gamePanel = new GamePanel();

    @Override
    public void drawTheme() {
        button = gamePanel.button;
        for (int i=0; i<9; i++){
            button[i].setBackground(new Color(0x00ff00));
            button[i].setBorder(BorderFactory.createLineBorder(new Color(0x056608),2));
        }

        PlayerMove playerMove = new PlayerMove(button,panel);
        playerMove.playerMove();
    }
}
