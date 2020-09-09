package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class BoardButtons {
    private JButton button[][] = new JButton[3][3];
    private Font font = new Font("Arial", Font.BOLD, 40);

    public JButton[][] drawButton() {
        for (int i=0; i<3; i++) {
            for(int j=0; j<3; j++){
                button[i][j] = new JButton();
                button[i][j].setBackground(Color.WHITE);
                button[i][j].setBorder(BorderFactory.createLineBorder(Color.black,2));
                button[i][j].setFont(font);
            }
        }
        return button;
    }
}
