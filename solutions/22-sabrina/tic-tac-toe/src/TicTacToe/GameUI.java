package TicTacToe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class GameUI {
    private JFrame frame;
    private Font f1, f2;
    private JPanel containerPanel, gamePanel, buttonPanel;
    private JLabel theme;
    private JRadioButton classicTheme, forrestTheme, highContrastTheme;
    private ButtonGroup themeButtonGroup;
    private JButton randomAIButton, defensiveAIButton;

    public GameUI() {
        drawBoard();
    }

    private void drawBoard() {
        frame = new JFrame();
        containerPanel = new JPanel();
        gamePanel = new JPanel();
        buttonPanel = new JPanel();
        themeButtonGroup = new ButtonGroup();

        gamePanel.setLayout(null);
        buttonPanel.setLayout(null);

        f1 = new Font("Arial", Font.BOLD, 20);
        f2 = new Font("Arial", Font.PLAIN, 15);

        theme = new JLabel("Theme");
        theme.setBounds(20, 50, 150, 50);
        theme.setFont(f1);
        buttonPanel.add(theme);

        classicTheme = new JRadioButton("Classic");
        classicTheme.setBounds(20, 90, 150, 50);
        classicTheme.setBackground(Color.WHITE);
        classicTheme.setFont(f2);
        buttonPanel.add(classicTheme);

        forrestTheme = new JRadioButton("Forrest");
        forrestTheme.setBounds(20,130,150,50);
        forrestTheme.setBackground(Color.WHITE);
        forrestTheme.setFont(f2);
        buttonPanel.add(forrestTheme);

        highContrastTheme = new JRadioButton("High Contrast");
        highContrastTheme.setBounds(20, 170,170,50);
        highContrastTheme.setBackground(Color.WHITE);
        highContrastTheme.setFont(f2);
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

        gamePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        gamePanel.setBackground(Color.WHITE);
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        buttonPanel.setBackground(Color.WHITE);

        containerPanel.setLayout(new GridLayout(1,2));
        containerPanel.add(gamePanel);
        containerPanel.add(buttonPanel);



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
