package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JButton[][] button;
    private String[][] moveString;
    private JPanel panel;
    BoardDecoration boardDecoration = new BoardDecoration();
    PlayGame playGame;

    public GamePanel(JButton button[][], JPanel panel, String[][] moveString){
        this.button=button;
        this.panel=panel;
        this.moveString=moveString;
        playGame = new PlayGame(button,moveString);

    }

    public JPanel drawBoardGrid(){

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j] = new JButton();
                button[i][j].setFont(boardDecoration.boardFont);
                button[i][j].addActionListener(playGame.toggleMove);
                panel.add(button[i][j]);
            }
        }

        return panel;
    }
}
