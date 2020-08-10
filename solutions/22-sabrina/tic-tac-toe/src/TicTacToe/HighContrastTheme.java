package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class HighContrastTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];
    private String theme = "highContrast";
    BoardButtons boardButtons = new BoardButtons(theme);

    public HighContrastTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawHighContrastTheme() {

        panel.setLayout(new GridLayout(3,3));
        button = boardButtons.drawButton(button);

        PlayerMove playerMove = new PlayerMove(button,panel);
        playerMove.playerMove();

        return panel;
    }
}
