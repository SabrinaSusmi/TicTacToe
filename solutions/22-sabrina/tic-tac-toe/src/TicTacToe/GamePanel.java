package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel {
    private JButton[][] button;
    private String[][] moveString;
    private JPanel panel;
    BoardDecoration boardDecoration = new BoardDecoration();
    PlayGame playGame;
    Move move = new Move();
    HasWinner hasWinner = new HasWinner();
    WinnerMessage winnerMessage = new WinnerMessage();
    RefreshBoard refreshBoard = new RefreshBoard();
    SelectAI selectAi;
    int moveCount=0;

    public GamePanel(JButton button[][], JPanel panel, String[][] moveString, SelectAI selectAi){
        this.button=button;
        this.panel=panel;
        this.moveString=moveString;
        this.selectAi= selectAi;
        //playGame = new PlayGame(button,moveString);

    }

    public JPanel drawBoardGrid(){

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j] = new JButton();
                button[i][j].setFont(boardDecoration.boardFont);
                button[i][j].addActionListener(toggleMove);
                panel.add(button[i][j]);
            }
        }

        return panel;
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
        }
    }
}
