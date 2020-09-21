package TicTacToe.Theme;

import javax.swing.*;

public class ApplyTheme {
    Theme theme;
    SelectTheme selectTheme;
    private JButton[][] buttonArray;
    ChangeIcon changeIcon;

    public ApplyTheme(SelectTheme selectTheme, JButton[][] buttonArray, String[][] buttonKeyTracker) {
        this.selectTheme = selectTheme;
        this.buttonArray = buttonArray;
        changeIcon = new ChangeIcon(selectTheme,buttonArray,buttonKeyTracker);
        setTheme();
    }

    public void setTheme(){
        theme = selectTheme.getTheme();
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                buttonArray[row][col].setBackground(theme.getBackgroundColor());
                buttonArray[row][col].setBorder(BorderFactory.createLineBorder(theme.getBorderColor(), 3));
            }
        }
    }
}
