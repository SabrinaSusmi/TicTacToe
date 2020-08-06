package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassicTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];
    private Font font;

    public ClassicTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawClassicTheme() {

        font = new Font("Arial", Font.BOLD, 30);

        panel.setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            button[i].setBackground(Color.WHITE);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
            panel.add(button[i]);
        }

        for (JButton button: button
             ) {
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(button.getText()==""){
                        button.setText("X");
                        button.setFont(font);
                    }
                }
            });

        }


        return panel;
    }
}
