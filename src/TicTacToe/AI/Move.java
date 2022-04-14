package TicTacToe.AI;

import TicTacToe.Board;

public class Move {

    public Board board;
    public int space;

    public Move( Board board, int space ) {

        this.board = board;
        this.space = space;
    }
}
