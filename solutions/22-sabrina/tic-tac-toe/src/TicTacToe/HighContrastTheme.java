package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class HighContrastTheme implements Theme{
    private JPanel panel;
    private JButton button[] = new JButton[9];
    private String theme = "highContrast";
    BoardButtons boardButtons = new BoardButtons(theme);

    @Override
    public JPanel drawTheme(JPanel panel) {
        panel.setLayout(new GridLayout(3,3));
        button = boardButtons.drawButton(button);

        PlayerMove playerMove = new PlayerMove(button,panel);
        playerMove.playerMove();

        return panel;
    }
}
