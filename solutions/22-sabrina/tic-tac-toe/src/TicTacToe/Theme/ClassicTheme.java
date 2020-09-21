package TicTacToe.Theme;

import TicTacToe.BoardDecoration;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements Theme {
    BoardDecoration boardDecoration = new BoardDecoration();
    BoardIcon boardIcon = new BoardIcon();

    public Color getBackgroundColor(){
        return boardDecoration.classicBoardColor;
    }

    public Color getBorderColor(){
        return boardDecoration.classicBorderColor;
    }

    @Override
    public Icon getPlayerIcon() {
        return boardIcon.getClassicThemePlayerIcon();
    }

    @Override
    public Icon getAIIcon() {
        return boardIcon.getClassicThemeAIIcon();
    }
}
