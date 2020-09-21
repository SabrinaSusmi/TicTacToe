package TicTacToe;

import TicTacToe.AI.SelectAI;
import TicTacToe.Theme.SelectTheme;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel {
    private JPanel panel;
    public JButton[][] buttonArray;
    public String[][] moveString;
    SelectAI selectAi;
    SelectTheme selectTheme;
    UIButtons uiButtons;

    public ButtonPanel(JButton buttonArray[][], String[][] moveString, SelectAI selectAi, SelectTheme selectTheme){
        this.buttonArray = buttonArray;
        this.moveString=moveString;
        this.selectAi=selectAi;
        this.selectTheme=selectTheme;
        uiButtons = new UIButtons(buttonArray,moveString,selectAi,selectTheme);
    }

    public JPanel drawButtonPanel(){
        panel = uiButtons.panel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createLineBorder(Color.black));
        panel.setBackground(Color.WHITE);

        return panel;
    }
}
