package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameUI {
    private JFrame frame;
    private JPanel containerPanel, gamePanelClassic, gamePanelForest, gamePanelHighContrast, panelButtons;
    private String themeName;



    public GameUI(String themeName) {
        //this.frame = frame;
        this.themeName = themeName;
        drawBoard();
    }

    private void drawBoard() {

        ButtonPanel buttonPanel = new ButtonPanel(frame);
        frame = new JFrame();
//        containerPanel = new JPanel();
//        gamePanelClassic = new JPanel();
//        gamePanelForest = new JPanel();
//        gamePanelHighContrast = new JPanel();
//        panelButtons = new JPanel();
//        panelButtons = buttonPanel.drawButtonPanel(panelButtons);
//
//        containerPanel.setLayout(new GridLayout(1,2));
//        containerPanel.add(panelButtons);
//
//
//        ClassicTheme classicThemeUI = new ClassicTheme(gamePanelClassic);
//        gamePanelClassic = classicThemeUI.drawClassicTheme();
//        ForestTheme forestThemeUI = new ForestTheme(gamePanelForest);
//        gamePanelForest = forestThemeUI.drawForestTheme();
//        HighContrastTheme highContrastThemeUI = new HighContrastTheme(gamePanelHighContrast);
//        gamePanelHighContrast = highContrastThemeUI.drawHighContrastTheme();
//
//
//        containerPanel.setLayout(new GridLayout(1,2));
//
//        if(themeName=="forest"){
//            containerPanel.add(gamePanelForest);
//        }
//        else if((themeName=="classic")||(themeName=="start")) {
//            containerPanel.add(gamePanelClassic);
//        }
//        else if(themeName=="highContrast"){
//            containerPanel.add(gamePanelHighContrast);
//        }
//
//        containerPanel.add(panelButtons);
//
//
//
//        frame.add(containerPanel);
        GameLauncher gameLauncher = new GameLauncher(frame, "start");
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setSize(1000,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
    }


    public static void main(String[] args) {
//        JFrame frame = new JFrame();
        new GameUI("start");
    }
}
