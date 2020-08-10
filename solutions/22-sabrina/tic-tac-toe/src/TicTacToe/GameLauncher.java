package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameLauncher {
    private JFrame frame;
    //private JPanel panel;
    private String themeName;
    private JPanel containerPanel, gamePanelClassic, gamePanelForest, gamePanelHighContrast, panelButtons;
    public GameLauncher(JFrame frame, String themeName) {
        this.frame=frame;
        this.themeName = themeName;
        classicAdder();
    }

    public void classicAdder() {
        ButtonPanel buttonPanel = new ButtonPanel(frame);
        containerPanel = new JPanel();
        gamePanelClassic = new JPanel();
        gamePanelForest = new JPanel();
        gamePanelHighContrast = new JPanel();
        panelButtons = new JPanel();
        panelButtons = buttonPanel.drawButtonPanel(panelButtons);

        ClassicTheme classicThemeUI = new ClassicTheme(gamePanelClassic);
        gamePanelClassic = classicThemeUI.drawClassicTheme();
        ForestTheme forestThemeUI = new ForestTheme(gamePanelForest);
        gamePanelForest = forestThemeUI.drawForestTheme();
        HighContrastTheme highContrastThemeUI = new HighContrastTheme(gamePanelHighContrast);
        gamePanelHighContrast = highContrastThemeUI.drawHighContrastTheme();

        containerPanel.setLayout(new GridLayout(1,2));
        if(themeName=="forest"){
            containerPanel.remove(gamePanelClassic);
            containerPanel.remove(gamePanelHighContrast);
            containerPanel.add(gamePanelForest);
        }
        else if((themeName=="classic")||(themeName=="start")) {
            containerPanel.add(gamePanelClassic);
        }
        else if(themeName=="highContrast"){
            containerPanel.add(gamePanelHighContrast);
        }
        //panel.add(gamePanelClassic);
       containerPanel.add(panelButtons);
        frame.add(containerPanel);
        frame.setResizable(false);
        frame.setSize(1000,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
    }
}
