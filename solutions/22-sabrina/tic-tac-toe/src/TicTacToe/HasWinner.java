package TicTacToe;

public class HasWinner {

    public boolean isWon(String[][] buttonKeyTracker){
        for(int i=0; i<3; i++){
            if(buttonKeyTracker[i][0]==buttonKeyTracker[i][1] && buttonKeyTracker[i][1]==buttonKeyTracker[i][2] && buttonKeyTracker[i][0]!=""){
                return true;
            }
            else if(buttonKeyTracker[0][i]==buttonKeyTracker[1][i] && buttonKeyTracker[1][i]==buttonKeyTracker[2][i] && buttonKeyTracker[0][i]!=""){
                return true;
            }
        }
        if((buttonKeyTracker[0][0]==buttonKeyTracker[1][1] && buttonKeyTracker[1][1]==buttonKeyTracker[2][2] && buttonKeyTracker[1][1]!="")
                || (buttonKeyTracker[0][2]==buttonKeyTracker[1][1] && buttonKeyTracker[1][1]==buttonKeyTracker[2][0] && buttonKeyTracker[1][1]!="")){
            return true;
        }
        return false;

    }
}
