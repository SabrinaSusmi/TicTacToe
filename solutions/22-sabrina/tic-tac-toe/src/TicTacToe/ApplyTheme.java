package TicTacToe;

import javax.swing.*;

public class ApplyTheme {
    Theme theme;
    SelectTheme selectTheme;
    private JButton[][] buttonArray;
    private String[][] moveString;

    public ApplyTheme(SelectTheme selectTheme, JButton[][] buttonArray, String[][] moveString) {
        this.selectTheme = selectTheme;
        this.buttonArray = buttonArray;
        this.moveString = moveString;
        setTheme();
    }

    public void setTheme(){
        theme = selectTheme.getTheme();
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                buttonArray[i][j].setBackground(theme.getBackgroundColor());
                buttonArray[i][j].setBorder(BorderFactory.createLineBorder(theme.getBorderColor(), 2));
                if(moveString[i][j]!= ""){
                    if(moveString[i][j]=="x"){
                        buttonArray[i][j].setText(theme.getPlayerIcon());
                    }
                    else {
                        buttonArray[i][j].setText(theme.getAIIcon());
                    }
                }
            }
        }
    }
}
