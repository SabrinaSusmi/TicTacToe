package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameUI {
    private JFrame frame;
    private JPanel containerPanel,panelButtons,panelGame;

    public GameUI() {
        drawBoard();
    }

    private void drawBoard() {

        ButtonPanel buttonPanel = new ButtonPanel();
        GamePanel gamePanel = new GamePanel();
        frame = new JFrame();
        containerPanel = new JPanel();
        panelGame = new JPanel();
        panelButtons = new JPanel();
        panelButtons = buttonPanel.drawButtonPanel(panelButtons);
        panelGame = gamePanel.drawBoardGrid(panelGame);

        containerPanel.setLayout(new GridLayout(1,2));
        containerPanel.add(panelGame);
        containerPanel.add(panelButtons);

        frame.add(containerPanel);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setSize(1000,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
    }


    public static void main(String[] args) {
//        JFrame frame = new JFrame();
        new GameUI();
    }
}
