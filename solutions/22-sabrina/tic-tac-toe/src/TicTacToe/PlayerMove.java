package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerMove {
    private JPanel panel;
    private JButton button[];
    private String currentPlayer = "x";
    private int moveCount=0;
    RandomAI randomAI = new RandomAI();

    public PlayerMove(JButton[] button, JPanel panel) {
        this.button = button;
        this.panel = panel;
    }

    public void playerMove() {
        for (int i=0; i<9; i++) {
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
    }
    private void togglePlayer(){
        if(currentPlayer=="o"){
            randomAI.randomMove(button);
            moveCount++;
            currentPlayer="x";
        }
    }
}
