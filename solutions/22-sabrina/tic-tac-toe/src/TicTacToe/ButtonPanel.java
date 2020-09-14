package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel {
    private JPanel buttonPanel;
    private JLabel theme;
    private JRadioButton classicTheme, forrestTheme, highContrastTheme;
    private ButtonGroup themeButtonGroup;
    private JButton randomAIButton, defensiveAIButton;
    BoardDecoration boardDecoration = new BoardDecoration();
    public JButton button[][] = new JButton[3][3];
    PlayGame playGame = new PlayGame();

    public void setButton(JButton button[][]){
        this.button=button;
    }

    public JPanel drawButtonPanel(JPanel buttonPanel){
        //this.buttonPanel = buttonPanel;
        themeButtonGroup = new ButtonGroup();

        buttonPanel.setLayout(null);

        theme = new JLabel("Theme");
        theme.setBounds(20, 50, 150, 50);
        theme.setFont(boardDecoration.buttonFont);
        buttonPanel.add(theme);

        setTheme("classic");

        classicTheme = new JRadioButton("Classic");
        classicTheme.setBounds(20, 90, 150, 50);
        classicTheme.setBackground(Color.WHITE);
        classicTheme.setFont(boardDecoration.labelFont);
        classicTheme.setSelected(true);
        buttonPanel.add(classicTheme);
        classicTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTheme("classic");
            }
        });

        forrestTheme = new JRadioButton("Forest");
        forrestTheme.setBounds(20,130,150,50);
        forrestTheme.setBackground(Color.WHITE);
        forrestTheme.setFont(boardDecoration.labelFont);
        buttonPanel.add(forrestTheme);
        forrestTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTheme("forest");
            }
        });

        highContrastTheme = new JRadioButton("High Contrast");
        highContrastTheme.setBounds(20, 170,170,50);
        highContrastTheme.setBackground(Color.WHITE);
        highContrastTheme.setFont(boardDecoration.labelFont);

        highContrastTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTheme("highContrast");
            }
        });
        buttonPanel.add(highContrastTheme);


        themeButtonGroup.add(classicTheme);
        themeButtonGroup.add(forrestTheme);
        themeButtonGroup.add(highContrastTheme);

        randomAIButton = new JButton("Start With Random AI");
        randomAIButton.setBounds(20, 300, 280, 45);
        randomAIButton.setFont(boardDecoration.buttonFont);
        randomAIButton.setBackground(Color.darkGray);
        randomAIButton.setForeground(Color.WHITE);
        randomAIButton.setBorder(null);
        randomAIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame.getAITYpe("random");
                playGame.setButton(button);
                playGame.move();
            }
        });
        //randomAIButton.setBorder(new RoundedShape(10));
        buttonPanel.add(randomAIButton);

        defensiveAIButton = new JButton("Start With Defensive AI");
        defensiveAIButton.setBounds(20, 360, 280, 45);
        defensiveAIButton.setFont(boardDecoration.buttonFont);
        defensiveAIButton.setBackground(Color.darkGray);
        defensiveAIButton.setForeground(Color.WHITE);
        defensiveAIButton.setBorder(null);
        defensiveAIButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame.getAITYpe("defensive");
                playGame.setButton(button);
                playGame.move();
            }
        });
        buttonPanel.add(defensiveAIButton);

        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonPanel.setBackground(Color.WHITE);

        return buttonPanel;
    }

    public void setTheme(String themeName){
        Theme theme;
        if(themeName=="forest"){
            theme=new ForestTheme();
            theme.getButton(button);
            theme.drawTheme();
        }
        else if(themeName=="classic") {
            theme = new ClassicTheme();
            theme.getButton(button);
            theme.drawTheme();
        }
        else if(themeName=="highContrast"){
            theme = new HighContrastTheme();
            theme.getButton(button);
            theme.drawTheme();
        }
    }
}
