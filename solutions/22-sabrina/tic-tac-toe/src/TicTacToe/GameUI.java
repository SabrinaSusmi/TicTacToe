package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI {
    private JFrame frame;
    private Font f1, f2;
    private JPanel containerPanel, gamePanelClassic, gamePanelForest, gamePanelHighContrast, buttonPanel;
    private JLabel theme;
    private JRadioButton classicTheme, forrestTheme, highContrastTheme;
    private ButtonGroup themeButtonGroup;
    private String themeName = "classic";
    private JButton randomAIButton, defensiveAIButton;



    public GameUI() {
        drawBoard();
    }

    private void drawBoard() {
        frame = new JFrame();
        containerPanel = new JPanel();
        gamePanelClassic = new JPanel();
        gamePanelForest = new JPanel();
        gamePanelHighContrast = new JPanel();
        buttonPanel = new JPanel();
        themeButtonGroup = new ButtonGroup();


        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Arial", Font.PLAIN, 15);

        //gamePanel = classicThemeUI.drawClassicTheme();


        //button panel
        buttonPanel.setLayout(null);

        theme = new JLabel("Theme");
        theme.setBounds(20, 50, 150, 50);
        theme.setFont(f1);
        buttonPanel.add(theme);

        classicTheme = new JRadioButton("Classic");
        classicTheme.setBounds(20, 90, 150, 50);
        classicTheme.setBackground(Color.WHITE);
        classicTheme.setFont(f2);
        classicTheme.setSelected(true);
        buttonPanel.add(classicTheme);
        classicTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themeName = "classic";
            }
        });

        forrestTheme = new JRadioButton("Forest");
        forrestTheme.setBounds(20,130,150,50);
        forrestTheme.setBackground(Color.WHITE);
        forrestTheme.setFont(f2);
        buttonPanel.add(forrestTheme);
        forrestTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themeName = "forest";
            }
        });

        highContrastTheme = new JRadioButton("High Contrast");
        highContrastTheme.setBounds(20, 170,170,50);
        highContrastTheme.setBackground(Color.WHITE);
        highContrastTheme.setFont(f2);

        highContrastTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 themeName = "highContrast";
            }
        });
        buttonPanel.add(highContrastTheme);


        themeButtonGroup.add(classicTheme);
        themeButtonGroup.add(forrestTheme);
        themeButtonGroup.add(highContrastTheme);

        randomAIButton = new JButton("Start With Random AI");
        randomAIButton.setBounds(20, 300, 280, 45);
        randomAIButton.setFont(f1);
        randomAIButton.setBackground(Color.darkGray);
        randomAIButton.setForeground(Color.WHITE);
        randomAIButton.setBorder(null);
        //randomAIButton.setBorder(new RoundedShape(10));
        buttonPanel.add(randomAIButton);

        defensiveAIButton = new JButton("Start With Defensive AI");
        defensiveAIButton.setBounds(20, 360, 280, 45);
        defensiveAIButton.setFont(f1);
        defensiveAIButton.setBackground(Color.darkGray);
        defensiveAIButton.setForeground(Color.WHITE);
        defensiveAIButton.setBorder(null);
        buttonPanel.add(defensiveAIButton);

        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonPanel.setBackground(Color.WHITE);

        //game panel

        //gamePanel=themeSwitcher(gamePanel);


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
        else if(themeName=="classic") {
            containerPanel.remove(gamePanelHighContrast);
            containerPanel.remove(gamePanelForest);
            containerPanel.add(gamePanelClassic);
        }
        else if(themeName=="highContrast"){
            containerPanel.remove(gamePanelForest);
            containerPanel.remove(gamePanelClassic);
            containerPanel.add(gamePanelHighContrast);
        }

        containerPanel.add(gamePanelHighContrast);
        containerPanel.add(buttonPanel);



        frame.add(containerPanel);
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setSize(1000,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
    }

    private JPanel themeSwitcher(JPanel gamePanel){
        //JPanel panel = new JPanel();
        if(themeName=="forest"){
            ForestTheme forestThemeUI = new ForestTheme(gamePanel);
            gamePanel = forestThemeUI.drawForestTheme();
        }
        else if(themeName=="classic") {
            ClassicTheme classicThemeUI = new ClassicTheme(gamePanel);
            gamePanel = classicThemeUI.drawClassicTheme();
        }
        else if(themeName=="highContrast"){
            HighContrastTheme highContrastThemeUI = new HighContrastTheme(gamePanel);
            gamePanel = highContrastThemeUI.drawHighContrastTheme();
        }
        return gamePanel;
    }



    public static void main(String[] args) {
        new GameUI();
    }
}
