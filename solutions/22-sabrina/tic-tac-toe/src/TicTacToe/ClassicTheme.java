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
    private String currentPlayer = "x";
    private int moveCount=0;
    RandomAI randomAI = new RandomAI();

    public ClassicTheme(JPanel panel) {
        this.panel = panel;
    }

    public JPanel drawClassicTheme() {
        panel.setLayout(new GridLayout(3,3));

        for (int i=0; i<9; i++) {
            button[i] = new JButton();
            button[i].setBackground(Color.WHITE);
            button[i].setBorder(BorderFactory.createLineBorder(Color.black,2));
            button[i].setFont(font);
            int index = i;
            button[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(((JButton) e.getSource()).getText().equals("") && currentPlayer=="x") {
                        button[index].setText("X");
                        currentPlayer="o";
                        moveCount++;
                        if(moveCount<=8){
                            togglePlayer();
                        }
                    }
                }
            });
            panel.add(button[i]);
        }


        return panel;
    }

    private void togglePlayer(){
        if(currentPlayer=="o"){
            randomAI.randomMove(button);
            moveCount++;
            currentPlayer="x";
        }
    }
}
