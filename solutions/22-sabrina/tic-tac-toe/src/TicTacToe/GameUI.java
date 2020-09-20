package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameUI {
    private JFrame frame = new JFrame();
    private JPanel containerPanel = new JPanel();
    public JButton buttonArray[][] = new JButton[3][3];
    public String[][] moveString = new String[3][3];
    ButtonPanel buttonPanel;
    GamePanel gamePanel;
    SelectAI selectAI = new SelectAI();
    PlayGame playGame;

    public GameUI() {
        createFrame();
    }

    private JPanel designBoard() {

        buttonPanel = new ButtonPanel(buttonArray,moveString,selectAI);
        gamePanel = new GamePanel(buttonArray,moveString,selectAI);
        playGame = new PlayGame(buttonArray,moveString,selectAI);

        containerPanel.setLayout(new GridLayout(1,2));
        containerPanel.add(gamePanel.drawBoardGrid());
        containerPanel.add(buttonPanel.drawButtonPanel());

        return containerPanel;
    }

    private void createFrame(){
        frame.add(designBoard());
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setSize(1000,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
    }
}
