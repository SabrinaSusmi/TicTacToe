package TicTacToe.Theme;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BoardIcon {
    private String classicPlayerIconPath = "../imageIcons/classicPlayer.png";
    private String classicAIIconPath = "../imageIcons/classicAI.png";
    private String forestPlayerIconPath = "../imageIcons/forestPlayer.png";
    private String forestAIIconPath = "../imageIcons/forestAI.png";
    private String highContrastPlayerIconPath = "../imageIcons/highContrastPlayer.jpg";
    private String highContrastAIIconPath = "../imageIcons/highContrastAI.jpg";
    public Icon getIcon(String path) {
        ImageIcon imageIcon = null;
        try {
            Image image = ImageIO.read(getClass().getResource(path));
            imageIcon = new ImageIcon(image.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        } catch (IOException e) {
            System.out.println(e + " Image insertion failed");
        }
        return imageIcon;
    }
    public Icon getClassicThemePlayerIcon() {
        return getIcon(classicPlayerIconPath);
    }
    public Icon getClassicThemeAIIcon() {
        return getIcon(classicAIIconPath);
    }
    public Icon getForestThemePlayerIcon() {
        return getIcon(forestPlayerIconPath);
    }
    public Icon getForestThemeAIIcon() {
        return getIcon(forestAIIconPath);
    }
    public Icon getHighContrastThemePlayerIcon() {
        return getIcon(highContrastPlayerIconPath);
    }
    public Icon getHighContrastThemeAIIcon() {
        return getIcon(highContrastAIIconPath);
    }
}
