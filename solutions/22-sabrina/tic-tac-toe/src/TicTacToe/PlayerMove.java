package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayerMove {
    private JButton button[][];
    private String currentPlayer = "x";
    private int moveCount=0;
    RandomAI randomAI = new RandomAI();

    public PlayerMove(JButton[][] button) {
        this.button = button;
    }

    private boolean isWon(){
        for(int i=0; i<3; i++){
            if(button[i][0].getText()==button[i][1].getText() && button[i][1].getText()==button[i][2].getText()
                 && (button[i][0].getText()=="x"||button[i][0].getText()=="o")){
                return true;
            }
            else if(button[0][i].getText()==button[1][i].getText() && button[1][i].getText()==button[2][i].getText()
                && (button[0][i].getText()=="x"||button[0][i].getText()=="o")){
                return true;
            }
        }
        if((button[0][0].getText()==button[1][1].getText() && button[1][1].getText()==button[2][2].getText())
                || (button[0][2].getText()==button[1][1].getText() && button[1][1].getText()==button[2][0].getText())
            && (button[1][1].getText()=="x"||button[1][1].getText()=="o")){
            return true;
        }
        return false;
    }

    private void newBoard(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setText("");
            }
        }
    }

    public void playerMove() {
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText().equals("") && currentPlayer == "x") {
                            button[row][col].setText("x");
                            if(isWon()==true){
                                newBoard();
                                moveCount=0;
                            }
                            else{
                                currentPlayer = "o";
                                moveCount++;
                                if (moveCount <= 8) {
                                    togglePlayer();
                                }
                            }
                        }
                    }
                });
            }
        }
    }
    private void togglePlayer(){
        if(currentPlayer=="o"){
            randomAI.move(button);
            if(isWon()==true){
                newBoard();
                moveCount=0;
            }
            else {
                moveCount++;
                currentPlayer="x";
            }
        }
    }
}
