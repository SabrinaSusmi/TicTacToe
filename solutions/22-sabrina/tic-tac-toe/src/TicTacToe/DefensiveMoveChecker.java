package TicTacToe;

public class DefensiveMoveChecker {
    String[][] moveString;

    public DefensiveMoveChecker(String[][] moveString) {
        this.moveString=moveString;
    }

    public boolean checkDefenseRow(){
        for(int i=0; i<3; i++){
            if (moveString[i][0] == moveString[i][1] && moveString[i][0] == "x" && moveString[i][2]=="") {
                return true;
            } else if (moveString[i][1] == moveString[i][2] && moveString[i][1] == "x" && moveString[i][0]=="") {
                return true;
            } else if(moveString[i][0] == moveString[i][2] && moveString[i][0] == "x" && moveString[i][1]==""){
                return true;
            }
        }
        return false;
    }

    public boolean checkDefenseColumn(){
        for(int i=0; i<3; i++){
            if (moveString[0][i] == moveString[1][i] && moveString[0][i] == "x" && moveString[2][i]=="") {
                return true;
            } else if (moveString[1][i] == moveString[2][i] && moveString[1][i] == "x" && moveString[0][i]=="") {
                return true;
            } else if(moveString[0][i] == moveString[2][i] && moveString[0][i] == "x" && moveString[1][i]==""){
                return true;
            }
        }
        return false;
    }

    public boolean checkDefenseFirstDiagonal() {
        for (int i = 0; i < 3; i++) {
            if(moveString[0][0]==moveString[1][1] && moveString[1][1]=="x" && moveString[2][2]==""){
                return true;
            } else if(moveString[2][2]==moveString[1][1] && moveString[1][1]=="x" && moveString[0][0]==""){
                return true;
            } else if(moveString[0][0]==moveString[2][2] && moveString[0][0]=="x" && moveString[1][1]==""){
                return true;
            }
        }
        return false;
    }

    public boolean checkDefenseSecondDiagonal() {
        for (int i = 0; i < 3; i++) {
            if(moveString[0][2]==moveString[1][1] && moveString[1][1]=="x" && moveString[2][0]==""){
                return true;
            } else if(moveString[2][0]==moveString[1][1] && moveString[1][1]=="x" && moveString[0][2]==""){
                return true;
            } else if(moveString[0][2]==moveString[2][0] && moveString[0][2]=="x" && moveString[1][1]==""){
                return true;
            }
        }
        return false;
    }
}
