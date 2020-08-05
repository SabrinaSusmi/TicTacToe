package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class BoardButtons {
    private JButton button[] = new JButton[9];

    public BoardButtons() {
        drawButton();
    }

    public JButton[] drawButton() {
        for (int i=0; i<9; i++) {
            button[i] = new JButton();
        }
        return button;
    }
}
