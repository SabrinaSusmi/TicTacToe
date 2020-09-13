package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame {
    JFrame frame = new JFrame("Winner Message");
    public JButton button[][] = new JButton[3][3];
    String moveString[][]= new String[3][3];
    String string;
    private String currentPlayer = "x";
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
        if(currentPlayer=="o") {
            ai.move(button,moveString);
            if(isWon()==true){
                JOptionPane.showMessageDialog(frame,"Player "+currentPlayer+" wins!");
                newBoard();
            }
            else {
                currentPlayer="x";
            }
        }
    }

    private boolean isWon(){
        for(int i=0; i<3; i++){
            if(button[i][0].getText()==currentPlayer && button[i][1].getText()==currentPlayer && button[i][2].getText()==currentPlayer){
                return true;
            }
            else if(button[0][i].getText()==currentPlayer && button[1][i].getText()==currentPlayer && button[2][i].getText()==currentPlayer){
                return true;
            }
        }
        if((button[0][0].getText()==currentPlayer && button[1][1].getText()==currentPlayer && button[2][2].getText()==currentPlayer)
                || (button[0][2].getText()==currentPlayer && button[1][1].getText()==currentPlayer && button[2][0].getText()==currentPlayer)){
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

    public void move(){

        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setSize(300,150);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (((JButton) e.getSource()).getText().equals("") && currentPlayer == "x"){
                            playersMove(button[row][col]);
                            if(isWon()==true){
                                JOptionPane.showMessageDialog(frame,"Player "+currentPlayer+" wins!");
                                newBoard();
                            }
                            else{
                                currentPlayer = "o";
                                if (isDraw()==true) {
                                    computersMove();
                                }
                                else{
                                    JOptionPane.showMessageDialog(frame, "Match Draw!");
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
}
