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
        createAIButtons();

        return panel;
    }

    private void createAIButtons(){
        randomAIButton = new JButton("Start With Random AI");
        randomAIButton.setBounds(20, 300, 280, 45);
        addAIButton(randomAIButton);

        defensiveAIButton = new JButton("Start With Defensive AI");
        defensiveAIButton.setBounds(20, 360, 280, 45);
        addAIButton(defensiveAIButton);
    }

    private void createThemeButtonGroup(){
        themeButtonGroup = new ButtonGroup();

        classicTheme = new JRadioButton("Classic");
        classicTheme.setBounds(20, 90, 150, 50);
        addThemeButton(classicTheme);

        forrestTheme = new JRadioButton("Forest");
        forrestTheme.setBounds(20,130,150,50);
        addThemeButton(forrestTheme);

        highContrastTheme = new JRadioButton("High Contrast");
        highContrastTheme.setBounds(20, 170,170,50);
        addThemeButton(highContrastTheme);

        themeButtonGroup.add(classicTheme);
        themeButtonGroup.add(forrestTheme);
        themeButtonGroup.add(highContrastTheme);
    }

    private void addAIButton(JButton button){
        button.setFont(boardDecoration.buttonFont);
        button.setBackground(Color.darkGray);
        button.setForeground(Color.WHITE);
        button.setBorder(null);
        button.addActionListener(aiButtonListener);
        panel.add(button);
    }

    private void addThemeButton(JRadioButton radioButton){
        radioButton.setBackground(Color.WHITE);
        radioButton.setFont(boardDecoration.labelFont);
        radioButton.addActionListener(radioButtonListener);
        panel.add(radioButton);
    }

    private ActionListener radioButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==classicTheme){
                switchTheme.setTheme("classic",buttonArray);
            }
            if(e.getSource()==forrestTheme){
                switchTheme.setTheme("forest",buttonArray);
            }
            if(e.getSource()==highContrastTheme){
                switchTheme.setTheme("highContrast",buttonArray);
            }
        }
    };

    private ActionListener aiButtonListener = new ActionListener() {
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
