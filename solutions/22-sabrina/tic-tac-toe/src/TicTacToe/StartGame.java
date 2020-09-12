package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartGame {
    JFrame frame = new JFrame("Winner Message");
    public JButton button[][] = new JButton[3][3];
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
            ai.move(button);
            if(isWon()==true){
                newBoard();
                JOptionPane.showMessageDialog(frame,"Player "+currentPlayer+" wins!");
            }
            else {
                currentPlayer="x";
            }
        }
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
                                newBoard();
                                JOptionPane.showMessageDialog(frame,"Player "+currentPlayer+" wins!");
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
