package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ForestTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];
    private String theme = "forest";
    BoardButtons boardButtons = new BoardButtons(theme);

    public ForestTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawForestTheme() {

        panel.setLayout(new GridLayout(3,3));

        button = boardButtons.drawButton(button);

        PlayerMove playerMove = new PlayerMove(button,panel);
        playerMove.playerMove();

        return panel;
    }
}
