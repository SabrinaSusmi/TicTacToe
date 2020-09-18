package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel {
    private JButton[][] button;
    private JPanel panel;
    BoardDecoration boardDecoration = new BoardDecoration();
    PlayGame playGame;
    SelectAI selectAi;

    public GamePanel(JButton button[][], JPanel panel, String[][] moveString, SelectAI selectAi){
        this.button=button;
        this.panel=panel;
        this.selectAi= selectAi;
        playGame = new PlayGame(button,moveString,selectAi);

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
