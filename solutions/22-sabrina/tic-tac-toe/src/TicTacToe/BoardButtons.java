package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class BoardButtons {
    private JButton button;

    public BoardButtons() {
        drawButton();
    }

    public JButton drawButton() {
        button = new JButton();
        button.setBackground(Color.WHITE);
        return button;
    }
}
