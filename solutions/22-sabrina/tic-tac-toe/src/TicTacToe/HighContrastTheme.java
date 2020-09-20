package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class HighContrastTheme implements Theme{
    BoardDecoration boardDecoration = new BoardDecoration();
    BoardIcon boardIcon = new BoardIcon();

    public Color getBackgroundColor(){
        return boardDecoration.highContrastBoardColor;
    }

    public Color getBorderColor(){
        return boardDecoration.highContrastBorderColor;
    }

    @Override
    public Icon getPlayerIcon() {
        return boardIcon.getHighContrastThemePlayerIcon();
    }

    @Override
    public Icon getAIIcon() {
        return boardIcon.getHighContrastThemeAIIcon();
    }
}
