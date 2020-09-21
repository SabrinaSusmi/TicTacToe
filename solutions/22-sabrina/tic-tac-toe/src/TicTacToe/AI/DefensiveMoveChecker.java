package TicTacToe.AI;

public class DefensiveMoveChecker {
    String[][] buttonKeyTracker;

    public DefensiveMoveChecker(String[][] buttonKeyTracker) {
        this.buttonKeyTracker = buttonKeyTracker;
    }

    public boolean checkDefenseRow(){
        for(int i=0; i<3; i++){
            if (buttonKeyTracker[i][0] == buttonKeyTracker[i][1] && buttonKeyTracker[i][0] == "x" && buttonKeyTracker[i][2]=="") {
                buttonKeyTracker[i][2]="defend";
                return true;
            } else if (buttonKeyTracker[i][1] == buttonKeyTracker[i][2] && buttonKeyTracker[i][1] == "x" && buttonKeyTracker[i][0]=="") {
                buttonKeyTracker[i][0]="defend";
                return true;
            } else if(buttonKeyTracker[i][0] == buttonKeyTracker[i][2] && buttonKeyTracker[i][0] == "x" && buttonKeyTracker[i][1]==""){
                buttonKeyTracker[i][1]="defend";
                return true;
            }
        }
        return false;
    }

    public boolean checkDefenseColumn(){
        for(int i=0; i<3; i++){
            if (buttonKeyTracker[0][i] == buttonKeyTracker[1][i] && buttonKeyTracker[0][i] == "x" && buttonKeyTracker[2][i]=="") {
                buttonKeyTracker[2][i]="defend";
                return true;
            } else if (buttonKeyTracker[1][i] == buttonKeyTracker[2][i] && buttonKeyTracker[1][i] == "x" && buttonKeyTracker[0][i]=="") {
                buttonKeyTracker[0][i]="defend";
                return true;
            } else if(buttonKeyTracker[0][i] == buttonKeyTracker[2][i] && buttonKeyTracker[0][i] == "x" && buttonKeyTracker[1][i]==""){
                buttonKeyTracker[1][i]="defend";
                return true;
            }
        }
        return false;
    }

    public boolean checkDefenseFirstDiagonal() {
        for (int i = 0; i < 3; i++) {
            if(buttonKeyTracker[0][0]== buttonKeyTracker[1][1] && buttonKeyTracker[1][1]=="x" && buttonKeyTracker[2][2]==""){
                buttonKeyTracker[2][2]="defend";
                return true;
            } else if(buttonKeyTracker[2][2]== buttonKeyTracker[1][1] && buttonKeyTracker[1][1]=="x" && buttonKeyTracker[0][0]==""){
                buttonKeyTracker[0][0]="defend";
                return true;
            } else if(buttonKeyTracker[0][0]== buttonKeyTracker[2][2] && buttonKeyTracker[0][0]=="x" && buttonKeyTracker[1][1]==""){
                buttonKeyTracker[1][1]="defend";
                return true;
            }
        }
        return false;
    }

    public boolean checkDefenseSecondDiagonal() {
        for (int i = 0; i < 3; i++) {
            if(buttonKeyTracker[0][2]== buttonKeyTracker[1][1] && buttonKeyTracker[1][1]=="x" && buttonKeyTracker[2][0]==""){
                buttonKeyTracker[2][0]="defend";
                return true;
            } else if(buttonKeyTracker[2][0]== buttonKeyTracker[1][1] && buttonKeyTracker[1][1]=="x" && buttonKeyTracker[0][2]==""){
                buttonKeyTracker[0][2]="defend";
                return true;
            } else if(buttonKeyTracker[0][2]== buttonKeyTracker[2][0] && buttonKeyTracker[0][2]=="x" && buttonKeyTracker[1][1]==""){
                buttonKeyTracker[1][1]="defend";
                return true;
            }
        }
        return false;
    }

    public boolean canBeDefended(){
        if(checkDefenseRow()){
            checkDefenseRow();
            return true;
        } else if(checkDefenseColumn()){
            checkDefenseColumn();
            return true;
        } else if(checkDefenseFirstDiagonal()){
            checkDefenseFirstDiagonal();
            return true;
        } else if(checkDefenseSecondDiagonal()){
            checkDefenseSecondDiagonal();
            return true;
        }
        return false;
    }
}
