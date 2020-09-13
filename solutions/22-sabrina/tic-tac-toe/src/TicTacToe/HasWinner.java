package TicTacToe;

public class HasWinner {
    public boolean isWon(String move, String[][] moveString){
        for(int i=0; i<3; i++){
            if(moveString[i][0]==move && moveString[i][1]==move && moveString[i][2]==move){
                return true;
            }
            else if(moveString[0][i]==move && moveString[1][i]==move && moveString[2][i]==move){
                return true;
            }
        }
        if((moveString[0][0]==move && moveString[1][1]==move && moveString[2][2]==move)
                || (moveString[0][2]==move && moveString[1][1]==move && moveString[2][0]==move)){
            return true;
        }
        return false;

    }
}
