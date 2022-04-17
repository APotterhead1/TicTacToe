package TicTacToe;

import TicTacToe.AI.*;

public class Game {

    public AI ai;
    public int turnOrder;
    public Board board;

    public Game( int playerNum ) {

        turnOrder = playerNum;
        board = new Board();
        ai = new AI();
    }

    public void CurrentPlayer( int turn ) {

        if( turn == 1 ) RunPlayer();
        else RunAI();

        int num = board.checkIfGameOver();

        if( num == 2 ) {
            if( turn == 1 ) CurrentPlayer( 2 );
            else CurrentPlayer( 1 );
        } else ai.train( num );
    }

    public void RunPlayer() {

        System.out.println();
    }

    public void RunAI() {

        board = ai.play( board );
    }

    public void blankLines() { for( int i = 0; i < 100; i++ ) System.out.println(); }
    public void line() { for( int i = 0; i < 100; i++ ) System.out.print( '#' ); System.out.println(); }
}
