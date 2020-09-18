package TicTacToe;

import javax.swing.*;

public class SwitchTheme {
    public void setTheme(String themeName, JButton[][] buttons){
        Theme theme;
        if(themeName=="forest"){
            theme=new ForestTheme();
            theme.getButton(buttons);
            theme.drawTheme();
        }
        else if(themeName=="classic") {
            theme = new ClassicTheme();
            theme.getButton(buttons);
            theme.drawTheme();
        }
        else if(themeName=="highContrast"){
            theme = new HighContrastTheme();
            theme.getButton(buttons);
            theme.drawTheme();
        }
    }
}
