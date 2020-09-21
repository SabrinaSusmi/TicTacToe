package TicTacToe;

import TicTacToe.AI.SelectAI;
import TicTacToe.Theme.ApplyTheme;
import TicTacToe.Theme.SelectTheme;

import javax.swing.*;
import java.awt.*;

public class GamePanel {
    private JButton[][] buttonArray;
    private String [][] buttonKeyTracker;
    private JPanel panel;
    PlayGame playGame;
    SelectAI selectAi;
    SelectTheme selectTheme;
    ManageBoard manageBoard = new ManageBoard();
    ApplyTheme applyTheme;

    public GamePanel(JButton buttonArray[][], String[][] buttonKeyTracker, SelectAI selectAi, SelectTheme selectTheme){
        this.buttonArray = buttonArray;
        this.selectAi= selectAi;
        this.selectTheme=selectTheme;
        this.buttonKeyTracker = buttonKeyTracker;
        playGame = new PlayGame(buttonArray, buttonKeyTracker,selectAi,selectTheme);
    }

    public JPanel drawBoardGrid(){

        panel = new JPanel();

        panel.setLayout(new GridLayout(3,3));
        for (int i=0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArray[i][j] = new JButton();
                buttonArray[i][j].addActionListener(playGame.toggleMove);
                panel.add(buttonArray[i][j]);
            }
        }
        manageBoard.refreshBoard(buttonArray, buttonKeyTracker);
        manageBoard.lockBoard(buttonArray);
        selectTheme.defaultTheme();
        applyTheme = new ApplyTheme(selectTheme,buttonArray);

        return panel;
    }
}
