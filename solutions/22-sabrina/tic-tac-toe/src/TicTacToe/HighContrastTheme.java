package TicTacToe;

import java.awt.*;

public class HighContrastTheme implements Theme{
    BoardDecoration boardDecoration = new BoardDecoration();

    public Color getBackgroundColor(){
        return boardDecoration.highContrastBoardColor;
    }

    public Color getBorderColor(){
        return boardDecoration.highContrastBorderColor;
    }
}
