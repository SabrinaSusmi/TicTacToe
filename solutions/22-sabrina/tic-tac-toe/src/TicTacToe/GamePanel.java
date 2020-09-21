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
        for (int row=0; row<3; row++) {
            for (int col = 0; col < 3; col++) {
                buttonArray[row][col] = new JButton();
                buttonArray[row][col].addActionListener(playGame.toggleMove);
                panel.add(buttonArray[row][col]);
            }
        }
        manageBoard.refreshBoard(buttonArray, buttonKeyTracker);
        manageBoard.isBoardUnlocked(buttonArray,false);
        selectTheme.defaultTheme();
        applyTheme = new ApplyTheme(selectTheme,buttonArray,buttonKeyTracker);

        return panel;
    }
}
