package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class BoardButtons {
    private JButton button[] = new JButton[9];
    private Font font = new Font("Arial", Font.BOLD, 40);
    private String theme;

    public BoardButtons(String theme) {
        this.theme = theme;
    }

    public JButton[] drawButton(JButton button[]) {
        this.button = button;
        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            if(theme=="forest"){
                button[i].setBackground(new Color(0x00ff00));
                button[i].setBorder(BorderFactory.createLineBorder(new Color(0x056608),2));
            }
            else if(theme=="classic") {
                button[i].setBackground(Color.WHITE);
                button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
            }
            else if(theme=="highContrast"){
                button[i].setBackground(new Color(0x69696f));
                button[i].setBorder(BorderFactory.createLineBorder(new Color(0xc0c0c0),2));
            }
            button[i].setFont(font);
        }
        return button;
    }
}
