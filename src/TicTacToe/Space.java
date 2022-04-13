package TicTacToe;

public class Space {
    public char value;

    public Space() {

        value = ' ';

    }

    public Space( char ch ) {

        value = ch;
    }

    public void makeX() {

        value = 'X';
    }

    public void makeO(){
        value = 'O';
    }

    public String toString() {

        return " " + value + " ";
    }
}
