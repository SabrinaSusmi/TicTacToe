package TicTacToe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ClassicTheme implements Theme{
    Image X;

    public ImageIcon getIconPlayer(){
        Image imageX = null; try {
            imageX = ImageIO.read(new File("src/TicTacToe/imageIcons/classicThemePlayerIcon.png"));
        } catch (IOException e) {
            System.out.println(e+" Image failed");
        }
        return new ImageIcon(imageX.getScaledInstance(120,120,Image.SCALE_AREA_AVERAGING));
    }

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

    public Icon getPlayersIcon(){
        return getIconPlayer();
    }
}
