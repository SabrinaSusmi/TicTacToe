package TicTacToe.Theme;

import TicTacToe.BoardDecoration;

import javax.swing.*;
import java.awt.*;

public class ClassicTheme implements Theme {


//    public ImageIcon getIconPlayer(){
//        Image imageX = null; try {
//            imageX = ImageIO.read(new File("src/TicTacToe/imageIcons/classicThemePlayerIcon.png"));
//        } catch (IOException e) {
//            System.out.println(e+" Image failed");
//        }
//        return new ImageIcon(imageX.getScaledInstance(120,120,Image.SCALE_AREA_AVERAGING));
//    }

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
