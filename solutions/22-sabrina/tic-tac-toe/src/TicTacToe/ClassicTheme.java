package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassicTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];
    private Font font = new Font("Arial", Font.BOLD, 30);

    public ClassicTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawClassicTheme() {
        panel.setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            button[i].setBackground(Color.WHITE);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
            panel.add(button[i]);
        }


        AIMove(button);


        return panel;
    }

    private void playerMove(JButton button[]){
        for (JButton b: button
        ) {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(b.getText()==""){
                        b.setText("X");
                        b.setFont(font);
                    }
                }
            });

        }
    }

    private void AIMove(JButton button[]){
        int index = (int)Math.random()%8;
        if(button[index].getText()==""){
            button[index].setText("O");
            button[index].setFont(font);
        }
        else {
            AIMove(button);
        }
    }
}
