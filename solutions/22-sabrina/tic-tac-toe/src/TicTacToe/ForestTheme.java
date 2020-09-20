package TicTacToe;

import java.awt.*;

public class ForestTheme implements Theme{
    BoardDecoration boardDecoration = new BoardDecoration();

    public Color getBackgroundColor(){
        return boardDecoration.forestBoardColor;
    }

    public Color getBorderColor(){
        return boardDecoration.forestBorderColor;
    }

    @Override
    public String getPlayerIcon() {
        return "F";
    }

    @Override
    public String getAIIcon() {
        return "R";
    }
}
