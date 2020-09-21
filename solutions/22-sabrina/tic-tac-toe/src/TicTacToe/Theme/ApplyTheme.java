package TicTacToe.Theme;

import javax.swing.*;

public class ApplyTheme {
    Theme theme;
    SelectTheme selectTheme;
    private JButton[][] buttonArray;

    public ApplyTheme(SelectTheme selectTheme, JButton[][] buttonArray) {
        this.selectTheme = selectTheme;
        this.buttonArray = buttonArray;
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
