package TicTacToe;

import javax.swing.*;

public class ChangeIcon {
    Theme theme;
    SelectTheme selectTheme;
    private JButton[][] buttonArray;
    private String[][] moveString;

    public ChangeIcon(SelectTheme selectTheme, JButton[][] buttonArray, String[][] moveString) {
        this.selectTheme = selectTheme;
        this.buttonArray = buttonArray;
        this.moveString = moveString;
        changeExistingIcon();
    }

    public void changeExistingIcon(){
        theme = selectTheme.getTheme();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(moveString[i][j]!= ""){
                    if(moveString[i][j]=="x"){
                        buttonArray[i][j].setIcon(theme.getPlayerIcon());
                    }
                    else {
                        buttonArray[i][j].setIcon(theme.getAIIcon());
                    }
                }
            }
        }
    }
}
