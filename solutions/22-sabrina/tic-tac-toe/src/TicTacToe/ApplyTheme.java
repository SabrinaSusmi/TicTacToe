package TicTacToe;

import javax.swing.*;

public class ApplyTheme {
    Theme theme;
    SelectTheme selectTheme;
    JButton[][] buttonArray;

    public ApplyTheme(SelectTheme selectTheme, JButton[][] buttonArray) {
        this.selectTheme = selectTheme;
        this.buttonArray = buttonArray;
    }

    public void setTheme(){
        theme = selectTheme.getTheme();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                buttonArray[i][j].setBackground(null);
            }
        }
    }
}
