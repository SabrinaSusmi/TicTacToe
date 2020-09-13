package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame {
    public JButton button[][] = new JButton[3][3];
    String moveString[][]= new String[3][3];
    String string;
    private String currentPlayer = "x";
    AI ai;
    GamePlay gamePlay = new GamePlay();
    HasWinner hasWinner = new HasWinner();

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

    private void newBoard(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setText("");
            }
        }
    }

    public void move(){
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText().equals("")){
                            gamePlay.setPlayerMove(button[row][col]);
                            moveString[row][col]="x";
                            if(hasWinner.isWon("x",moveString)==true){
                                winnerMessage(currentPlayer);
                                newBoard();
                            }
                            else{
                                currentPlayer = "o";
                                if (isDraw()==true) {
                                    gamePlay.setComputerMove(ai,button,moveString);
                                    if(hasWinner.isWon("o",moveString)==true){
                                        winnerMessage(currentPlayer);
                                        newBoard();
                                    }
                                    else {
                                        currentPlayer="x";
                                    }
                                }
                                else{
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
