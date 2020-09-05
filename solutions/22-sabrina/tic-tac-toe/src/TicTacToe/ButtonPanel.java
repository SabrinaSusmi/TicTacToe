package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel {
    private JFrame frame;
    private JPanel buttonPanel;
    private Font f1, f2;
    private JLabel theme;
    private JRadioButton classicTheme, forrestTheme, highContrastTheme;
    private ButtonGroup themeButtonGroup;
    private JButton randomAIButton, defensiveAIButton;
    public JButton button[] = new JButton[9];

    public void getButton(JButton button[]){
        this.button=button;
    }

    public JPanel drawButtonPanel(JPanel buttonPanel){
        this.buttonPanel = buttonPanel;
        themeButtonGroup = new ButtonGroup();


        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Arial", Font.PLAIN, 15);

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
                changeTheme("classic");
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
                changeTheme("forest");
            }
        });

        highContrastTheme = new JRadioButton("High Contrast");
        highContrastTheme.setBounds(20, 170,170,50);
        highContrastTheme.setBackground(Color.WHITE);
        highContrastTheme.setFont(f2);

        highContrastTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeTheme("highContrast");
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

        return buttonPanel;
    }

    public void changeTheme(String themeName){
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
