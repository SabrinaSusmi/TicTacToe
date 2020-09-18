package TicTacToe;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayGame {
    private JButton[][] button;
    private String[][] moveString;
    Move move = new Move();
    HasWinner hasWinner = new HasWinner();
    WinnerMessage winnerMessage = new WinnerMessage();
    RefreshBoard refreshBoard = new RefreshBoard();
    SelectAI selectAi;
    int moveCount=0;

    public PlayGame(JButton[][] button, String[][] moveString,SelectAI selectAi){
        this.button=button;
        this.moveString=moveString;
        this.selectAi=selectAi;
    }

    public ActionListener toggleMove = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for (int row = 0;  row< 3; row++) {
                for (int col = 0; col< 3; col++) {
                    if (e.getSource().equals(button[row][col])) {
                        if (button[row][col].getText() == "") {
                            move.setPlayerMove(button[row][col]);
                            moveString[row][col] = "x";
                            moveCount++;
                            checkWinner("X");
                            if (moveCount == 9) {
                                moveCount = 0;
                                winnerMessage.displayWinnerDialogueBox("Match Draw!");
                                refreshBoard.refreshBoard(button, moveString);
                                refreshBoard.lockBoard(button);
                            }
                            if (moveCount >= 1) {
                                move.setComputerMove(selectAi.getAi(),button, moveString);
                                moveCount++;
                            }
                            checkWinner("O");
                        }
                    }
                }
            }
        }
    } ;

    private void checkWinner(String player){
        if (hasWinner.isWon(moveString) == true) {
            moveCount = 0;
            winnerMessage.displayWinnerDialogueBox("Player" + player + " wins!");
            refreshBoard.refreshBoard(button, moveString);
            refreshBoard.lockBoard(button);
        }
    }
}
