package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame {
    public JButton button[][] = new JButton[3][3];
    String string;
    private String currentPlayer = "x";
    private int moveCount=0;
    AI ai;

    public void getButton(JButton button[][]){
        this.button=button;
    }

    public void getAITYpe(String string){
        this.string=string;
        if(string=="random"){
            ai = new RandomAI();
        }
        else {
            ai= new DefensiveAI();
        }
    }

    public void playersMove(JButton button){
        button.setText("x");
    }

    public void computersMove(){
        ai.move(button);
        moveCount++;
        currentPlayer="x";
    }

    public void move(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText().equals("") && currentPlayer == "x"){
                            playersMove(button[row][col]);
                            currentPlayer = "o";
                            moveCount++;
                            if (moveCount <= 8) {
                                computersMove();
                            }
                        }
                    }
                });
            }
        }
    }
}
