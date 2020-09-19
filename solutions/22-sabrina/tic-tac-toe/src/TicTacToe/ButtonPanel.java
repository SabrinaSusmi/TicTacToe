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
    public JButton[][] buttonArray;
    public String[][] moveString;
    AI ai;
    SwitchTheme switchTheme = new SwitchTheme();
    ManageBoard manageBoard = new ManageBoard();
    SelectAI selectAi;

    public ButtonPanel(JButton buttonArray[][], JPanel panel, String[][] moveString, SelectAI selectAi){
        this.buttonArray = buttonArray;
        this.panel=panel;
        this.moveString=moveString;
        this.selectAi=selectAi;
    }

    public JPanel drawButtonPanel(){
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setBackground(Color.WHITE);

        theme = new JLabel("Theme");
        theme.setBounds(20, 50, 150, 50);
        theme.setFont(boardDecoration.buttonFont);
        panel.add(theme);

        switchTheme.setTheme("classic", buttonArray);

        createThemeButtonGroup();

        randomAIButton = new JButton("Start With Random AI");
        randomAIButton.setBounds(20, 300, 280, 45);
        addAIButton(randomAIButton);

        defensiveAIButton = new JButton("Start With Defensive AI");
        defensiveAIButton.setBounds(20, 360, 280, 45);
        addAIButton(defensiveAIButton);

        return panel;
    }

    private void createThemeButtonGroup(){
        themeButtonGroup = new ButtonGroup();
        classicTheme = new JRadioButton("Classic");
        classicTheme.setBounds(20, 90, 150, 50);
        classicTheme.setBackground(Color.WHITE);
        classicTheme.setFont(boardDecoration.labelFont);
        classicTheme.setSelected(true);
        panel.add(classicTheme);
        classicTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTheme.setTheme("classic",buttonArray);
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
                switchTheme.setTheme("forest",buttonArray);
            }
        });

        highContrastTheme = new JRadioButton("High Contrast");
        highContrastTheme.setBounds(20, 170,170,50);
        highContrastTheme.setBackground(Color.WHITE);
        highContrastTheme.setFont(boardDecoration.labelFont);

        highContrastTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTheme.setTheme("highContrast",buttonArray);
            }
        });
        panel.add(highContrastTheme);


        themeButtonGroup.add(classicTheme);
        themeButtonGroup.add(forrestTheme);
        themeButtonGroup.add(highContrastTheme);
    }

    private void addAIButton(JButton button){
        button.setFont(boardDecoration.buttonFont);
        button.setBackground(Color.darkGray);
        button.setForeground(Color.WHITE);
        button.setBorder(null);
        button.addActionListener(selectAI);
        panel.add(button);
    }

    private ActionListener selectAI = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            manageBoard.refreshBoard(buttonArray,moveString);
            manageBoard.unlockBoard(buttonArray);
            if(e.getSource()==defensiveAIButton){
                ai = new DefensiveAI();
                selectAi.setAI(ai);
            }
            if(e.getSource()==randomAIButton){
                ai = new RandomAI();
                selectAi.setAI(ai);
            }
        }
    };
}
