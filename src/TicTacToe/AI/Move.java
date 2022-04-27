package TicTacToe.AI;

import TicTacToe.Board;

public class Move {

    public Board board02;
    public int space;

    public Move(Board board02, int space ) {

        this.board02 = new Board( board02 );
        this.space = space;
    }

    public String toString() {

        return board02.toString();
    }
}
