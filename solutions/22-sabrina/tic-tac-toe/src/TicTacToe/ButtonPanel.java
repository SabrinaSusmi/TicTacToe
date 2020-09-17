package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel {
    private JPanel panel;
    private JLabel theme;
    private JRadioButton classicTheme, forrestTheme, highContrastTheme;
    private ButtonGroup themeButtonGroup;
    private JButton randomAIButton, defensiveAIButton;
    BoardDecoration boardDecoration = new BoardDecoration();
    public JButton[][] button;
    public String[][] moveString;
    AI ai;
    PlayGame playGame;
    RefreshBoard refreshBoard = new RefreshBoard();

    public ButtonPanel(JButton button[][], JPanel panel, String[][] moveString){
        this.button=button;
        this.panel=panel;
        this.moveString=moveString;
        playGame = new PlayGame(button,moveString);
    }

    public JPanel drawButtonPanel(){
        //this.buttonPanel = buttonPanel;
        themeButtonGroup = new ButtonGroup();

        panel.setLayout(null);

        theme = new JLabel("Theme");
        theme.setBounds(20, 50, 150, 50);
        theme.setFont(boardDecoration.buttonFont);
        panel.add(theme);

        setTheme("classic");

        classicTheme = new JRadioButton("Classic");
        classicTheme.setBounds(20, 90, 150, 50);
        classicTheme.setBackground(Color.WHITE);
        classicTheme.setFont(boardDecoration.labelFont);
        classicTheme.setSelected(true);
        panel.add(classicTheme);
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
        panel.add(forrestTheme);
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
        panel.add(highContrastTheme);


        themeButtonGroup.add(classicTheme);
        themeButtonGroup.add(forrestTheme);
        themeButtonGroup.add(highContrastTheme);

        randomAIButton = new JButton("Start With Random AI");
        randomAIButton.setBounds(20, 300, 280, 45);
        randomAIButton.setFont(boardDecoration.buttonFont);
        randomAIButton.setBackground(Color.darkGray);
        randomAIButton.setForeground(Color.WHITE);
        randomAIButton.setBorder(null);
        randomAIButton.addActionListener(selectAI);
        //randomAIButton.setBorder(new RoundedShape(10));
        panel.add(randomAIButton);

        defensiveAIButton = new JButton("Start With Defensive AI");
        defensiveAIButton.setBounds(20, 360, 280, 45);
        defensiveAIButton.setFont(boardDecoration.buttonFont);
        defensiveAIButton.setBackground(Color.darkGray);
        defensiveAIButton.setForeground(Color.WHITE);
        defensiveAIButton.setBorder(null);
        defensiveAIButton.addActionListener(selectAI);
        panel.add(defensiveAIButton);

        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setBackground(Color.WHITE);

        return panel;
    }

    private ActionListener selectAI = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            refreshBoard.refreshBoard(button,moveString);
            if(e.getSource()==defensiveAIButton){
                ai = new DefensiveAI();
                playGame.setAITYpe(ai);
                playGame.move();
            }
            if(e.getSource()==randomAIButton){
                ai = new RandomAI();
                playGame.setAITYpe(ai);
                playGame.move();
            }
        }
    };

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
