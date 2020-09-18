package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JButton[][] buttonArray;
    private JPanel panel;
    BoardDecoration boardDecoration = new BoardDecoration();
    PlayGame playGame;
    SelectAI selectAi;

    public GamePanel(JButton buttonArray[][], JPanel panel, String[][] moveString, SelectAI selectAi){
        this.buttonArray = buttonArray;
        this.panel=panel;
        this.selectAi= selectAi;
        playGame = new PlayGame(buttonArray,moveString,selectAi);

    }

    public JPanel drawBoardGrid(){

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArray[i][j] = new JButton();
                buttonArray[i][j].setFont(boardDecoration.boardFont);
                buttonArray[i][j].addActionListener(playGame.toggleMove);
                panel.add(buttonArray[i][j]);
            }
        }

        return panel;
    }
}
