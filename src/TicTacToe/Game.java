package TicTacToe;

import TicTacToe.AI.AI;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Game {

    public AI ai;
    public Board board;

    public Game( int playerNum ) {

        board = new Board();
        ai = new AI();
        CurrentPlayer( playerNum );
    }

    public void CurrentPlayer( int turn ) {

        if( turn == 1 ) RunPlayer();
        else RunAI();

        int num = board.checkIfGameOver();

        if( num == 2 ) {
            if( turn == 1 ) CurrentPlayer( 2 );
            else CurrentPlayer( 1 );
        } else {

            ai.train( num );
        }
    }

    public void RunPlayer() {
        Scanner kb = new Scanner( System.in );
        Queue<String> q = new LinkedList<String>();

        q.add( "Show Board" );

        while( true ) {

            if( q.peek().equals( "Show Board" ) ) {
                q.poll();

                blankLines();
                line();
                System.out.println();
                System.out.println("It's Your Turn!\nYou Are X, Current Board:");
                System.out.println( board );
                System.out.println();
                System.out.println( "Please Enter The Number For The Space That You Wish To Play In\nSpaces Are Numbered 1-9 Left To Right Then Top To Bottom");
                System.out.println();
                line();
                System.out.print('>');
                String str = kb.nextLine();

                if( str.equals( "1" ) ) {

                    if( isLegal( 1 ) ) {
                        board.board[ 0 ][ 0 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "2" ) ) {

                    if( isLegal( 2 ) ) {
                        board.board[ 0 ][ 1 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "3" ) ) {

                    if( isLegal( 3 ) ) {
                        board.board[ 0 ][ 2 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "4" ) ) {

                    if( isLegal( 4 ) ) {
                        board.board[ 1 ][ 0 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "5" ) ) {

                    if( isLegal( 5 ) ) {
                        board.board[ 1 ][ 1 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "6" ) ) {

                    if( isLegal( 6 ) ) {
                        board.board[ 1 ][ 2 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "7" ) ) {

                    if( isLegal( 7 ) ) {
                        board.board[ 2 ][ 0 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "8" ) ) {

                    if( isLegal( 8 ) ) {
                        board.board[ 2 ][ 1 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "9" ) ) {

                    if( isLegal( 9 ) ) {
                        board.board[ 2 ][ 2 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else {
                    q.add( "Invalid Position" );
                }
            }

            if( q.peek().equals( "Space Taken" ) ) {
                q.poll();

                blankLines();
                line();
                System.out.println();
                System.out.println( "The Space You Entered Was Already Taken\nPlease Try Again\n\nPress ENTER To Continue" );
                System.out.println();
                line();
                kb.nextLine();
                q.add( "Show Board" );
            }

            if( q.peek().equals( "Invalid Position" ) ) {
                q.poll();

                blankLines();
                line();
                System.out.println();
                System.out.println( "The Value Entered Could Not Be Processed\nPlease Try Again\n\nPress ENTER To Continue" );
                System.out.println();
                line();
                kb.nextLine();
                q.add( "Show Board" );
            }
        }
    }

    public void RunAI() {

        board = ai.play( board );
    }

    public boolean isLegal( int position ) {

        int num2 = ( position - 1 ) % 3;
        int num1 = ( position - 1 ) - num2 * 3;

        return board.board[num1][num2].value == ' ';
    }

    public void blankLines() { for( int i = 0; i < 100; i++ ) System.out.println(); }
    public void line() { for( int i = 0; i < 100; i++ ) System.out.print( '#' ); System.out.println(); }
}
