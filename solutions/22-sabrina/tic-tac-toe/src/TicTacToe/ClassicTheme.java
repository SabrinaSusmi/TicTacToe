package TicTacToe;

import java.awt.*;

public class ClassicTheme implements Theme{
    BoardDecoration boardDecoration = new BoardDecoration();

    public Color getBackgroundColor(){
        return boardDecoration.classicBoardColor;
    }

    public Color getBorderColor(){
        return boardDecoration.classicBorderColor;
    }

    @Override
    public String getPlayerIcon() {
        return "C";
    }

    @Override
    public String getAIIcon() {
        return "L";
    }
}
