package TicTacToe.AI;

import java.io.File;
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

                for(int i = 0; i < board.board04.length; i++ ) {
                    for(int j = 0; j < board.board04[i].length; j++ ) {

                        if( spaces[index].charAt( 0 ) == '_' ) board.board04[i][j].value = ' ';
                        else board.board04[i][j].value = spaces[index].charAt( 0 );
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

        Set mapKeySet = map.keySet();

        System.out.println( map.size() );
        System.out.println( moves.size() );

        for( int i = 0; i < moves.size(); i++ ) System.out.println( moves.get( i ));

        for( Object o : mapKeySet ) {

            System.out.println( o );
        }

        if( success == 0 ) return;
        if( success == 1 ) {

            for( int i = 0; i < moves.size(); i++ ) {

                int chance = (int) ( map.get( moves.get( i ).board02).get( moves.get( i ).space ) );

                int num1 = chance / moves.size();

                Map<Integer, Integer> map2 = new TreeMap<Integer, Integer>();

                map2.put( moves.get( i ).space, chance + chance / (moves.size() + 1) * ( i + 1 ) );

                map.put( moves.get( i ).board02, map2 );
            }
        }
        if( success == -1 ) {

            for( int i = 0; i < moves.size(); i++ ) {

                System.out.println( "test" );

                int chance = (int) ( map.get( moves.get( i ).board02).get( moves.get( i ).space ) );

                int num1 = chance / moves.size();

                Map<Integer, Integer> map2 = new TreeMap<Integer, Integer>();

                map2.put( moves.get( i ).space, chance - chance / (moves.size() + 1) * ( i + 1 ) );

                map.put( moves.get( i ).board02, map2 );
            }
        }

        moves = new ArrayList< Move >();
    }

    public Board play( Board board05 ) {

        Board board01 = new Board( board05 );

        if( !map.containsKey( board01 ) ) {

            Map<Integer, Integer> map1 = new TreeMap<Integer, Integer>();
            for( int i = 0; i < 9; i++ ) map1.put( i, 500 );

            System.out.println( board01 );
            map.put( new Board( board01 ), map1 );

            moves.add( new Move( new Board( board01 ), (int) ( Math.random() * 9 ) ) );

            return runMove();
        }

        Map chances = map.get( board01 );

        Set chancesKeySet = chances.keySet();

        int total = 0;

        Map<Integer, ArrayList<Move>> map2 = new TreeMap<Integer, ArrayList<Move>>();

        for( Object o : chancesKeySet ) {

            int num = (int) o;

            if( map2.containsKey( chances.get( num ) ) ) {

                map2.get( chances.get( num ) ).add( new Move( board01, num ) );

            } else {

                ArrayList<Move> list = new ArrayList<Move>();

                list.add( new Move( new Board( board01 ), num ) );

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

        int num1 = move.space / 3;
        int num2 = move.space % 3;

        Board b = move.board02;

        if( move.board02.board04[ num1 ][ num2 ].value != ' ' ) {
            map.get( move.board02).put( move.space, 0 );
            play( move.board02);
        } else {
            b = new Board( move.board02 );
            b.board04[ num1 ][ num2 ].makeO();
        }
        return b;
    }
}
