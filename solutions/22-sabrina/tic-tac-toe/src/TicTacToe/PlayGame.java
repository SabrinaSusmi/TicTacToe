package TicTacToe;

import TicTacToe.AI.SelectAI;
import TicTacToe.Theme.SelectTheme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGame {
    private JButton[][] buttonArray;
    private String[][] buttonKeyTracker;
    Move move;
    HasWinner hasWinner = new HasWinner();
    WinnerMessage winnerMessage = new WinnerMessage();
    ManageBoard manageBoard = new ManageBoard();
    SelectAI selectAi;
    int moveCount=0;

    public PlayGame(JButton[][] buttonArray, String[][] buttonKeyTracker, SelectAI selectAi, SelectTheme selectTheme){
        this.buttonArray = buttonArray;
        this.buttonKeyTracker =buttonKeyTracker;
        this.selectAi=selectAi;
        move = new Move(selectTheme);
    }

    public ActionListener toggleMove = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int row = 0;  row< 3; row++) {
                for (int col = 0; col< 3; col++) {
                    if (e.getSource().equals(buttonArray[row][col])) {
                        if (buttonKeyTracker[row][col] == "") {
                            move.setPlayerMove(buttonArray[row][col]);
                            buttonKeyTracker[row][col] = "x";
                            moveCount++;
                            if (hasWinner.isWon(buttonKeyTracker) == true){
                                gameOver("X");
                            }
                            if (moveCount == 9) {
                                gameOver("draw");
                            }
                            if (moveCount >= 1) {
                                move.setComputerMove(selectAi.getAi(), buttonArray, buttonKeyTracker);
                                moveCount++;
                            }
                            if (hasWinner.isWon(buttonKeyTracker) == true){
                                gameOver("O");
                            }
                        }
                    }
                }
            }
        }
    } ;

    private void gameOver(String player){
        if(player.equals("draw")){
            winnerMessage.displayWinnerDialogueBox("Match Draw!");
        } else {
            winnerMessage.displayWinnerDialogueBox("Player " + player + " wins!");
        }

        moveCount = 0;
        manageBoard.refreshBoard(buttonArray, buttonKeyTracker);
        manageBoard.lockBoard(buttonArray);
    }
}
