package TicTacToe;

import TicTacToe.AI.DefensiveMoveChecker;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class DefenseCheckTest {
    String[][] strings = new String[3][3];
    boolean defend;
    DefensiveMoveChecker defensiveMoveChecker;
    @Test
    public void RowDefenseCheckTest1(){
        strings[0][0]="";
        strings[0][1]="x";
        strings[0][2]="x";
        defensiveMoveChecker = new DefensiveMoveChecker(strings);
        defend = defensiveMoveChecker.checkDefenseRow();
        Assertions.assertTrue(defend);
    }

    @Test
    public void RowDefenseCheckTest2(){
        strings[0][0]="";
        strings[0][1]="";
        strings[0][2]="x";
        defensiveMoveChecker = new DefensiveMoveChecker(strings);
        defend = defensiveMoveChecker.checkDefenseRow();
        Assertions.assertFalse(defend);
    }

    @Test
    public void RowDefenseCheckTest3(){
        strings[0][0]="x";
        strings[0][1]="";
        strings[0][2]="x";
        defensiveMoveChecker = new DefensiveMoveChecker(strings);
        defend = defensiveMoveChecker.checkDefenseRow();
        Assertions.assertTrue(defend);
    }

    @Test
    public void columnDefenseCheckTest1(){
        strings[0][0]="x";
        strings[1][0]="";
        strings[2][0]="x";
        defensiveMoveChecker = new DefensiveMoveChecker(strings);
        defend = defensiveMoveChecker.checkDefenseColumn();
        Assertions.assertTrue(defend);
    }

    @Test
    public void columnDefenseCheckTest2(){
        strings[0][1]="";
        strings[1][1]="x";
        strings[2][1]="x";
        defensiveMoveChecker = new DefensiveMoveChecker(strings);
        defend = defensiveMoveChecker.checkDefenseColumn();
        Assertions.assertTrue(defend);
    }

    @Test
    public void columnDefenseCheckTest3(){
        strings[0][0]="x";
        strings[1][0]="";
        strings[2][0]="";
        defensiveMoveChecker = new DefensiveMoveChecker(strings);
        defend = defensiveMoveChecker.checkDefenseColumn();
        Assertions.assertFalse(defend);
    }

}
