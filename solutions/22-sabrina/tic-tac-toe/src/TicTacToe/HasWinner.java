package TicTacToe;

public class HasWinner {
    public boolean isWon(String[][] moveString){
        for(int i=0; i<3; i++){
            if(moveString[i][0]==moveString[i][1] && moveString[i][1]==moveString[i][2] && moveString[i][0]!=""){
                return true;
            }
            else if(moveString[0][i]==moveString[1][i] && moveString[1][i]==moveString[2][i] && moveString[0][i]!=""){
                return true;
            }
        }
        if((moveString[0][0]==moveString[1][1] && moveString[1][1]==moveString[2][2] && moveString[1][1]!="")
                || (moveString[0][2]==moveString[1][1] && moveString[1][1]==moveString[2][0] && moveString[1][1]!="")){
            return true;
        }
        return false;

    }
}
