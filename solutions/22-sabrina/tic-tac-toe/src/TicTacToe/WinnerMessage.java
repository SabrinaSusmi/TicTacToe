package TicTacToe;

import javax.swing.*;

public class WinnerMessage {
    JFrame frame;

    public void displayWinnerDialogueBox(String message){
        JOptionPane.showMessageDialog(createDialogueFrame(), message);
    }
    private JFrame createDialogueFrame(){
        frame = new JFrame("Winner Message");
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return frame;
    }
}
