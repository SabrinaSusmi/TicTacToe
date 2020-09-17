package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGame {
    private JButton[][] button;
    private String[][] moveString;
    AI ai;
    Move move = new Move();
    HasWinner hasWinner = new HasWinner();
    WinnerMessage winnerMessage = new WinnerMessage();
    RefreshBoard refreshBoard = new RefreshBoard();
    int moveCount=0;

    public PlayGame(JButton[][] button, String[][] moveString){
        this.button=button;
        this.moveString=moveString;
    }

    public void setAITYpe(AI ai){
        this.ai = ai;
    }

    public void move(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int row = i;
                int col = j;
                button[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(button[row][col])) {
                            if(button[row][col].getText()==""){
                                move.setPlayerMove(button[row][col]);
                                moveString[row][col] = "x";
                                moveCount++;
                                if (hasWinner.isWon("x", moveString) == true){
                                    moveCount=0;
                                    winnerMessage.displayWinnerDialogueBox("Player X wins!");
                                    refreshBoard.refreshBoard(button,moveString);
                                }
                                if(moveCount>=1){
                                    move.setComputerMove(ai, button, moveString);
                                    moveCount++;
                                }
                                if (hasWinner.isWon("o", moveString) == true){
                                    moveCount=0;
                                    winnerMessage.displayWinnerDialogueBox("Player O wins!");
                                    refreshBoard.refreshBoard(button,moveString);
                                }
                                if(moveCount==9){
                                    moveCount=0;
                                    winnerMessage.displayWinnerDialogueBox("Match Draw!");
                                    refreshBoard.refreshBoard(button,moveString);
                                }

                            }
                        }
                    }
                });
            }
        }
    }
}
