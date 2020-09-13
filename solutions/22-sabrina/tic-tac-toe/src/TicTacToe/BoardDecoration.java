package TicTacToe;

import java.awt.*;

public class BoardDecoration {
    Font labelFont, buttonFont, boardFont;
    Color classicBoardColor, forestBoardColor, highContrastBoardColor, classicBorderColor, forestBorderColor, highContrastBorderColor;

    public void font(){
        labelFont = new Font("Arial", Font.BOLD, 15);
        buttonFont = new Font("Arial", Font.BOLD, 20);
        boardFont = new Font("Arial", Font.BOLD, 40);
    }

    public void color(){
        classicBoardColor = new Color(0xffffff);
        classicBorderColor = new Color(0x000000);
        forestBoardColor = new Color(0x00ff00);
        forestBorderColor = new Color(0x056608);
        highContrastBoardColor = new Color(0x69696f);
        highContrastBorderColor = new Color(0xc0c0c0);
    }

}
