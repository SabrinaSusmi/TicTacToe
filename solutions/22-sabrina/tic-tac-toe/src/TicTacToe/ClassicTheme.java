package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ClassicTheme {
    private JPanel panel;
    private JButton button[] = new JButton[9];
    private Font font = new Font("Arial", Font.BOLD, 30);
    private String currentPlayer;

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

        currentPlayer = "x";

        for(int i=0; i<9; i++){
            if(currentPlayer=="x"){
                playerMove(button);
                currentPlayer="o";
            }
            else {
                AIMove(button);
                currentPlayer="x";
            }
        }


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
        int index = new Random().nextInt(9);
        while(true){
            if(button[index].getText()!=""){
                index = new Random().nextInt(9);
            }
            else
                break;
        }
        button[index].setText("O");
        button[index].setFont(font);
    }
}
