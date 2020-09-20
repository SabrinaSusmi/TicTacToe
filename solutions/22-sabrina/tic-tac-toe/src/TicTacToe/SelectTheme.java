package TicTacToe;

public class SelectTheme {
    Theme theme;
    public void setTheme(Theme theme){
        this.theme=theme;
    }

    public Theme getTheme(){
        return theme;
    }

    public void defaultTheme(){
        theme = new ClassicTheme();
    }
}
