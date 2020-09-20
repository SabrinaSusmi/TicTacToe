package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ForestTheme implements Theme{
    BoardDecoration boardDecoration = new BoardDecoration();
    BoardIcon boardIcon = new BoardIcon();

    public Color getBackgroundColor(){
        return boardDecoration.forestBoardColor;
    }

    public Color getBorderColor(){
        return boardDecoration.forestBorderColor;
    }

    @Override
    public Icon getPlayerIcon() {
        return boardIcon.getForestThemePlayerIcon();
    }

    @Override
    public Icon getAIIcon() {
        return boardIcon.getForestThemeAIIcon();
    }
}
