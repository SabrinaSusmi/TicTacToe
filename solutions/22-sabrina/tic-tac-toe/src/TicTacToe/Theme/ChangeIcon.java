package TicTacToe.Theme;

import javax.swing.*;

public class ChangeIcon {
    Theme theme;
    SelectTheme selectTheme;
    private JButton[][] buttonArray;
    private String[][] moveString;

    public ChangeIcon(SelectTheme selectTheme, JButton[][] buttonArray, String[][] buttonKeyTracker) {
        this.selectTheme = selectTheme;
        this.buttonArray = buttonArray;
        this.moveString = buttonKeyTracker;
        changeExistingIcon();
    }

    public void changeExistingIcon(){
        theme = selectTheme.getTheme();
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                if(moveString[row][col]!= ""){
                    if(moveString[row][col]=="x"){
                        buttonArray[row][col].setIcon(theme.getPlayerIcon());
                    }
                    else {
                        buttonArray[row][col].setIcon(theme.getAIIcon());
                    }
                }
            }
        }
    }
}
