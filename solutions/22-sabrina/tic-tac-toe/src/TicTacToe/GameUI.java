package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameUI {
    private JFrame frame = new JFrame();
    private JPanel containerPanel = new JPanel();
    private JPanel panelButtons = new JPanel();;
    private JPanel panelGame = new JPanel();
    public JButton button[][] = new JButton[3][3];
    ButtonPanel buttonPanel = new ButtonPanel();
    GamePanel gamePanel = new GamePanel();

    public GameUI() {
        designBoard();
    }

    private void designBoard() {

        drawBoard();

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

    public void drawBoard(){
        BoardButtons boardButtons = new BoardButtons();
        button=boardButtons.drawButton();
        gamePanel.getButton(button);
        buttonPanel.getButton(button);
        panelButtons = buttonPanel.drawButtonPanel(panelButtons);
        panelGame = gamePanel.drawBoardGrid(panelGame);
    }


    public static void main(String[] args) {
        new GameUI();
    }
}
