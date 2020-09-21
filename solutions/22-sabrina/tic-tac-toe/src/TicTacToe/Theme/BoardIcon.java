package TicTacToe.Theme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BoardIcon {
    private String classicPlayerIconPath = "src/TicTacToe/imageIcons/classicPlayer.png";
    private String classicAIIconPath = "src/TicTacToe/imageIcons/classicAI.png";
    private String forestPlayerIconPath = "src/TicTacToe/imageIcons/forestPlayer.png";
    private String forestAIIconPath = "src/TicTacToe/imageIcons/forestAI.png";
    private String highContrastPlayerIconPath = "src/TicTacToe/imageIcons/highContrastPlayer.jpg";
    private String highContrastAIIconPath = "src/TicTacToe/imageIcons/highContrastAI.jpg";

    public Icon getIcon(String path){
        Image image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println(e+" Image failed");
        }
        return new ImageIcon(image.getScaledInstance(200,200,Image.SCALE_SMOOTH));
    }

    public Icon getClassicThemePlayerIcon(){
        return getIcon(classicPlayerIconPath);
    }

    public Icon getClassicThemeAIIcon(){
        return getIcon(classicAIIconPath);
    }

    public Icon getForestThemePlayerIcon(){
        return getIcon(forestPlayerIconPath);
    }

    public Icon getForestThemeAIIcon(){
        return getIcon(forestAIIconPath);
    }

    public Icon getHighContrastThemePlayerIcon(){
        return getIcon(highContrastPlayerIconPath);
    }

    public Icon getHighContrastThemeAIIcon(){
        return getIcon(highContrastAIIconPath);
    }
}
