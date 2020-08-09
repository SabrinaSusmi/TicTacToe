package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameUI {
    private JFrame frame;
    private Font f1, f2;
    private JPanel containerPanel, gamePanelClassic, gamePanelForest, gamePanelHighContrast, panelButtons;
    private JLabel theme;
    private JRadioButton classicTheme, forrestTheme, highContrastTheme;
    private ButtonGroup themeButtonGroup;
    private String themeName = "classic";
    private JButton randomAIButton, defensiveAIButton;



    public GameUI() {
        drawBoard();
    }

    private void drawBoard() {

        ButtonPanel buttonPanel = new ButtonPanel();
        frame = new JFrame();
        containerPanel = new JPanel();
        gamePanelClassic = new JPanel();
        gamePanelForest = new JPanel();
        gamePanelHighContrast = new JPanel();
        panelButtons = new JPanel();
        panelButtons = buttonPanel.drawButtonPanel(panelButtons);
        themeButtonGroup = new ButtonGroup();


        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Arial", Font.PLAIN, 15);

        //gamePanel=themeSwitcher(gamePanel);


        ClassicTheme classicThemeUI = new ClassicTheme(gamePanelClassic);
        gamePanelClassic = classicThemeUI.drawClassicTheme();
        ForestTheme forestThemeUI = new ForestTheme(gamePanelForest);
        gamePanelForest = forestThemeUI.drawForestTheme();
        HighContrastTheme highContrastThemeUI = new HighContrastTheme(gamePanelHighContrast);
        gamePanelHighContrast = highContrastThemeUI.drawHighContrastTheme();


        containerPanel.setLayout(new GridLayout(1,2));

        containerPanel.add(gamePanelClassic);
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
        new GameUI();
    }
}
