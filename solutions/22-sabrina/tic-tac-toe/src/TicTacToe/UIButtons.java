package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIButtons {
    private JPanel panel;
    private JLabel theme;
    private JRadioButton classicTheme, forrestTheme, highContrastTheme;
    private ButtonGroup themeButtonGroup;
    private JButton randomAIButton, defensiveAIButton;
    BoardDecoration boardDecoration = new BoardDecoration();
    ManageBoard manageBoard = new ManageBoard();
    public JButton[][] buttonArray;
    public String[][] moveString;
    SelectAI selectAi;
    SelectTheme selectTheme;
    ApplyTheme applyTheme;

    public UIButtons(JButton[][] buttonArray, String[][] moveString, SelectAI selectAi, SelectTheme selectTheme) {
        this.buttonArray = buttonArray;
        this.moveString = moveString;
        this.selectAi = selectAi;
        this.selectTheme = selectTheme;
    }

    public JPanel panel(){
        createButtons();
        return panel;
    }

    private void createButtons(){
        panel = new JPanel();
        theme = new JLabel("Theme");
        theme.setBounds(20, 50, 150, 50);
        theme.setFont(boardDecoration.buttonFont);
        panel.add(theme);

        themeButtonGroup = new ButtonGroup();

        classicTheme = new JRadioButton("Classic");
        classicTheme.setBounds(20, 90, 150, 50);
        classicTheme.setSelected(true);
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

        randomAIButton = new JButton("Start With Random AI");
        randomAIButton.setBounds(20, 300, 280, 45);
        addAIButton(randomAIButton);

        defensiveAIButton = new JButton("Start With Defensive AI");
        defensiveAIButton.setBounds(20, 360, 280, 45);
        addAIButton(defensiveAIButton);
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
                selectTheme.setTheme(new ClassicTheme());
                applyTheme = new ApplyTheme(selectTheme,buttonArray);
            }
            if(e.getSource()==forrestTheme){
                selectTheme.setTheme(new ForestTheme());
                applyTheme = new ApplyTheme(selectTheme,buttonArray);
            }
            if(e.getSource()==highContrastTheme){
                selectTheme.setTheme(new HighContrastTheme());
                applyTheme = new ApplyTheme(selectTheme,buttonArray);
            }
        }
    };

    private ActionListener aiButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            manageBoard.refreshBoard(buttonArray,moveString);
            manageBoard.unlockBoard(buttonArray);
            if(e.getSource()==defensiveAIButton){
                selectAi.setAI(new DefensiveAI());
            }
            if(e.getSource()==randomAIButton){
                selectAi.setAI(new RandomAI());
            }
        }
    };
}
