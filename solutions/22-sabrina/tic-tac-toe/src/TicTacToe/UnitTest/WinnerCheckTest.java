package TicTacToe.UnitTest;

import TicTacToe.HasWinner;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class WinnerCheckTest {
    String[][] strings = new String[3][3];
    boolean won;
    HasWinner hasWinner = new HasWinner();

    @Test
    public void firstRowWinnerCheck(){
        strings[0][0]="x";
        strings[1][1]="o";
        strings[0][1]="x";
        strings[2][0]="o";
        strings[0][2]="x";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }

    @Test
    public void secondRowWinnerCheck(){
        strings[1][0]="x";
        strings[0][1]="o";
        strings[1][1]="x";
        strings[2][0]="o";
        strings[1][2]="x";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }

    @Test
    public void thirdRowWinnerCheck(){
        strings[2][0]="o";
        strings[0][1]="x";
        strings[2][1]="o";
        strings[1][0]="x";
        strings[2][2]="o";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }

    @Test
    public void firstColumnWinnerCheck(){
        strings[0][0]="x";
        strings[0][1]="o";
        strings[1][0]="x";
        strings[2][2]="o";
        strings[2][0]="x";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }

    @Test
    public void secondColumnWinnerCheck(){
        strings[0][1]="x";
        strings[0][0]="o";
        strings[1][1]="x";
        strings[2][0]="o";
        strings[2][1]="x";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }

    @Test
    public void thirdColumnWinnerCheck(){
        strings[0][2]="x";
        strings[0][1]="o";
        strings[1][2]="x";
        strings[2][0]="o";
        strings[2][2]="x";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }

    @Test
    public void firstDiagonalWinnerCheck(){
        strings[0][0]="x";
        strings[0][1]="o";
        strings[1][1]="x";
        strings[2][0]="o";
        strings[2][2]="x";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }

    @Test
    public void secondDiagonalWinnerCheck(){
        strings[0][2]="x";
        strings[0][1]="o";
        strings[1][1]="x";
        strings[2][2]="o";
        strings[2][0]="x";
        won = hasWinner.isWon(strings);
        Assertions.assertTrue(won);
    }
}
