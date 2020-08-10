package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme {
    private JPanel panel;
    private String theme = "classic";
    BoardButtons boardButtons = new BoardButtons(theme);
    private JButton button[]= new JButton[9];

    public ClassicTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawClassicTheme() {
        panel.setLayout(new GridLayout(3,3));
        button = boardButtons.drawButton(button);
        PlayerMove playerMove = new PlayerMove(button,panel);
        playerMove.playerMove();

        return panel;
    }

}
