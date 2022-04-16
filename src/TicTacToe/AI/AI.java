package TicTacToe.AI;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.ArrayList;
import TicTacToe.Board;

public class AI {

    public Map<Board, Map<Integer, Integer>> map;
    public ArrayList<Move> moves;

    public AI() {

        try {
            File file = new File("ai.dat");

            Scanner scanner = new Scanner( file );

            map = new TreeMap<Board, Map<Integer, Integer>>();

            while( scanner.hasNext() ) {

                int[] chances = new int[9];

                for( int i = 0; i < chances.length; i++ ) chances[i] = scanner.nextInt();

                String str = scanner.nextLine();

                String[] spaces = str.split("\\s+");

                Board board = new Board();

                int index = 0;

                for( int i = 0; i < board.board.length; i++ ) {
                    for( int j = 0; j < board.board[i].length; j++ ) {

                        if( spaces[index].charAt( 0 ) == '_' ) board.board[i][j].value = ' ';
                        else board.board[i][j].value = spaces[index].charAt( 0 );
                    }
                }

                Map<Integer, Integer> map1 = new TreeMap<Integer, Integer>();

                for( int i = 0; i < chances.length; i++ ) map1.put( i + 1, chances[ i ] );

                map.put( board, map1 );
            }

        } catch( IOException e ) {}

        moves = new ArrayList<Move>();
    }

    public void train( int success ) {

        if( success == 0 ) return;
        if( success == 1 );
        if( success == -1 );
    }

    public Board play( Board board ) {

        if( !map.containsKey( board ) ) {

            Map<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
            for( int i = 0; i < 9; i++ ) map1.put( i, 500 );

            map.put( board, map1 );

            moves.add( new Move( board, (int) ( Math.random() * 9 ) ) );

            return runMove();
        }

        Map chances = map.get( board );

        Set chancesKeySet = map.keySet();

        int total = 0;

        Map<Integer, ArrayList<Move>> map2 = new TreeMap<Integer, ArrayList<Move>>();

        for( Object o : chancesKeySet ) {

            int num = (int) o;

            if( map2.containsKey( chances.get( num ) ) ) {

                map2.get( chances.get( num ) ).add( new Move( board, num ) );

            } else {

                ArrayList<Move> list = new ArrayList<Move>();

                list.add( new Move( board, num ) );

                map2.put( (Integer) chances.get( num ), list );

                total += (int) chances.get( num );
            }
        }

        int rand = (int) ( Math.random() * total + 1 );

        Set map2KeySet = map2.keySet();

        ArrayList<Integer> list = new ArrayList<Integer>();

        for( Object o : map2KeySet ) {

            int chance = (int) o;

            list.add( 0, chance );
        }

        for( int i = 0; i < list.size(); i++ ) {

            total -= list.get( 0 );

            if( rand > total ) {

                moves.add( map2.get( list.get( 0 ) ).get( (int) (Math.random() * map2.get( list.get( 0 ) ).size() ) ) );
                break;
            }

            list.remove( 0 );
        }

        return runMove();
    }

    public Board runMove() {

        Move move = moves.get( moves.size() - 1 );

        int num2 = move.space % 3;
        int num1 = move.space - num2 * 3;

        if( move.board.board[ num1 ][ num2 ].value != ' ' ) {
            map.get( move.board ).put( move.space, 0 );
            play( move.board );
        }

        move.board.board[ num1 ][ num2 ].makeO();

        return move.board;
    }
}
