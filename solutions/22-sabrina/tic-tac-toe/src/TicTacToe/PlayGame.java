package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGame {
    public JButton button[][] = new JButton[3][3];
    String moveString[][]= new String[3][3];
    private String currentPlayer = "x";
    AI ai;
    Move move = new Move();
    HasWinner hasWinner = new HasWinner();
    int moveCount=0;

    public void setButton(JButton button[][]){
        this.button=button;
    }

    public void getAITYpe(String string){
        if(string=="random"){
            ai = new RandomAI();
        }
        else {
            ai= new DefensiveAI();
        }
    }

    private void newBoard(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setText("");
                moveString[i][j]="";
            }
        }
    }

    public void move(){
        newBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText().equals("")) {
                            move.setPlayerMove(button[row][col]);
                            moveCount++;
                            moveString[row][col] = "x";
                            if (hasWinner.isWon("x", moveString) == true) {
                                moveCount=0;
                                winnerMessage(currentPlayer);
                                newBoard();
                            } else {
                                currentPlayer = "o";
                                if (isDraw()==true) {
                                    move.setComputerMove(ai, button, moveString);
                                    moveCount++;
                                    if (hasWinner.isWon("o", moveString) == true) {
                                        moveCount=0;
                                        winnerMessage(currentPlayer);
                                        newBoard();
                                    } else {
                                        currentPlayer = "x";
                                    }
                                } else {
                                    moveCount=0;
                                    winnerMessage("draw");
                                    newBoard();
                                }
                            }
                        }
                    }
                });
            }
        }
    }

    private boolean isDraw(){
        boolean flag=false;
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                if(button[i][j].getText()==""){
                    flag=true;
                }
            }
        }
        return flag;
    }

    private void winnerMessage(String currentPlayer){
        JFrame frame = new JFrame("Winner Message");
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(currentPlayer=="x"){
            JOptionPane.showMessageDialog(frame,"Player "+currentPlayer+" wins!");
        }
        else if(currentPlayer=="o"){
            JOptionPane.showMessageDialog(frame,"Player "+currentPlayer+" wins!");
        }
        else{
            JOptionPane.showMessageDialog(frame, "Match Draw!");
        }
    }
}
