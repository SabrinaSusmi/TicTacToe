package TicTacToe;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class UnitTest {
    @Test
    public void firstRowWinnerCheck(){
        String[][] strings = new String[3][3];
        boolean won;
        HasWinner hasWinner = new HasWinner();

        strings[0][0]="x";
        strings[1][1]="o";
        strings[0][1]="x";
        strings[2][0]="o";
        strings[0][2]="x";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }
}
