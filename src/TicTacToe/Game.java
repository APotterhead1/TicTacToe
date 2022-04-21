package TicTacToe;

import TicTacToe.AI.AI;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Game {

    public AI ai;
    public Board board03;

    public Game( int playerNum ) {

        board03 = new Board();
        ai = new AI();
        currentPlayer( playerNum );
    }

    public void currentPlayer( int turn ) {

        if( turn == 1 ) RunPlayer();
        else RunAI();

        int num = board03.checkIfGameOver();

        if( num == 2 ) {
            if( turn == 1 ) currentPlayer( 2 );
            else currentPlayer( 1 );
        } else {
            blankLines();
            line();
            System.out.println();
            if( num == -1 ) System.out.println("You Won, Congratulations!");
            if( num == 1 ) System.out.println( "You Lost, Sorry" );
            if( num == 0 ) System.out.println( "It Was A Tie" );
            System.out.println();
            System.out.println(board03);
            System.out.println();
            System.out.println( "Press ENTER To Continue" );
            System.out.println();
            line();
            Scanner kb = new Scanner( System.in );
            kb.nextLine();

            ai.train( num );

            board03 = new Board();
            currentPlayer( 2 );
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
                System.out.println(board03);
                System.out.println();
                System.out.println( "Please Enter The Number For The Space That You Wish To Play In\nSpaces Are Numbered 1-9 Left To Right Then Top To Bottom");
                System.out.println();
                line();
                System.out.print('>');
                String str = kb.nextLine();

                if( str.equals( "1" ) ) {

                    if( isLegal( 1 ) ) {
                        board03.board04[ 0 ][ 0 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "2" ) ) {

                    if( isLegal( 2 ) ) {
                        board03.board04[ 0 ][ 1 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "3" ) ) {

                    if( isLegal( 3 ) ) {
                        board03.board04[ 0 ][ 2 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "4" ) ) {

                    if( isLegal( 4 ) ) {
                        board03.board04[ 1 ][ 0 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "5" ) ) {

                    if( isLegal( 5 ) ) {
                        board03.board04[ 1 ][ 1 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "6" ) ) {

                    if( isLegal( 6 ) ) {
                        board03.board04[ 1 ][ 2 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "7" ) ) {

                    if( isLegal( 7 ) ) {
                        board03.board04[ 2 ][ 0 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "8" ) ) {

                    if( isLegal( 8 ) ) {
                        board03.board04[ 2 ][ 1 ].makeX();
                        break;
                    } else q.add( "Space Taken" );
                } else if( str.equals( "9" ) ) {

                    if( isLegal( 9 ) ) {
                        board03.board04[ 2 ][ 2 ].makeX();
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
        Board board1 = new Board(board03);
        board03 = ai.play( board1 );
    }

    public boolean isLegal( int position ) {

        int num1 = ( position - 1 ) / 3;
        int num2 = ( position - 1 ) % 3;

        return board03.board04[num1][num2].value == ' ';
    }

    public void blankLines() { for( int i = 0; i < 3; i++ ) System.out.println(); }
    public void line() { for( int i = 0; i < 100; i++ ) System.out.print( '#' ); System.out.println(); }
}
