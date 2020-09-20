package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JButton[][] buttonArray;
    private JPanel panel;
    BoardDecoration boardDecoration = new BoardDecoration();
    PlayGame playGame;
    SelectAI selectAi;
    ManageBoard manageBoard = new ManageBoard();

    public GamePanel(JButton buttonArray[][], String[][] moveString, SelectAI selectAi){
        this.buttonArray = buttonArray;
        this.selectAi= selectAi;
        playGame = new PlayGame(buttonArray,moveString,selectAi);
    }

    public JPanel drawBoardGrid(){

        panel = new JPanel();

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArray[i][j] = new JButton();
                buttonArray[i][j].setFont(boardDecoration.boardFont);
                buttonArray[i][j].addActionListener(playGame.toggleMove);
                panel.add(buttonArray[i][j]);
            }
        }
        manageBoard.lockBoard(buttonArray);

        return panel;
    }
}
