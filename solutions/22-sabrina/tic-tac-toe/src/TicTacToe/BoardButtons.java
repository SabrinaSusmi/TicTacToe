package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class BoardButtons {
    private JButton button[] = new JButton[9];
    private Font font = new Font("Arial", Font.BOLD, 40);

    public BoardButtons() {
    }

    public JButton[] drawButton(JButton button[]) {
        this.button = button;
        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            button[i].setBackground(Color.WHITE);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
            button[i].setFont(font);
        }
        return button;
    }
}
