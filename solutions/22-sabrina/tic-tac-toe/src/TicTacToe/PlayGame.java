package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGame {
    private JButton[][] buttonArray;
    private String[][] moveString;
    Move move = new Move();
    HasWinner hasWinner = new HasWinner();
    WinnerMessage winnerMessage = new WinnerMessage();
    ManageBoard manageBoard = new ManageBoard();
    SelectAI selectAi;
    int moveCount=0;

    public PlayGame(JButton[][] buttonArray, String[][] moveString, SelectAI selectAi){
        this.buttonArray = buttonArray;
        this.moveString=moveString;
        this.selectAi=selectAi;
    }

    public ActionListener toggleMove = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int row = 0;  row< 3; row++) {
                for (int col = 0; col< 3; col++) {
                    if (e.getSource().equals(buttonArray[row][col])) {
                        if (buttonArray[row][col].getText() == "") {
                            move.setPlayerMove(buttonArray[row][col]);
                            moveString[row][col] = "x";
                            moveCount++;
                            if (hasWinner.isWon(moveString) == true){
                                gameOver("X");
                            }
                            if (moveCount == 9) {
                                gameOver(null);
                            }
                            if (moveCount >= 1) {
                                move.setComputerMove(selectAi.getAi(), buttonArray, moveString);
                                moveCount++;
                            }
                            if (hasWinner.isWon(moveString) == true){
                                gameOver("O");
                            }
                        }
                    }
                }
            }
        }
    } ;

    private void gameOver(String player){
        if(player.equals(null)){
            winnerMessage.displayWinnerDialogueBox("Match Draw!");
        } else {
            winnerMessage.displayWinnerDialogueBox("Player" + player + " wins!");
        }
        
        moveCount = 0;
        manageBoard.refreshBoard(buttonArray, moveString);
        manageBoard.lockBoard(buttonArray);
    }
}
