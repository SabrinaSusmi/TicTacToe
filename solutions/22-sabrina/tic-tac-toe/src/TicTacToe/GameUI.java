package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameUI {
    private JFrame frame = new JFrame();
    private JPanel containerPanel = new JPanel();
    private JPanel panelButtons,panelGame;
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
        panelGame = new JPanel();
        panelButtons = new JPanel();

        buttonPanel = new ButtonPanel(buttonArray,panelGame,moveString,selectAI);
        gamePanel = new GamePanel(buttonArray,panelButtons,moveString,selectAI);
        playGame = new PlayGame(buttonArray,moveString,selectAI);

        panelGame = gamePanel.drawBoardGrid();
        panelButtons = buttonPanel.drawButtonPanel();

        containerPanel.setLayout(new GridLayout(1,2));
        containerPanel.add(panelGame);
        containerPanel.add(panelButtons);

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
