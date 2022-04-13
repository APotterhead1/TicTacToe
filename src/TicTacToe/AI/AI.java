package TicTacToe.AI;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import TicTacToe.Board;

public class AI {

    public Map<Board, Map<Integer, Integer>> map;


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

                        board.board[i][j].value = spaces[index].charAt( 0 );
                    }
                }

                Map<Integer, Integer> map1 = new TreeMap<Integer, Integer>();

                for( int i = 0; i < chances.length; i++ ) map1.put( i + 1, chances[ i ] );

                map.put( board, map1 );
            }

        } catch( IOException e ) {}
    }

    public void train( int success ) {

        if( success == 0 ) return;
        if( success == 1 );
        if( success == -1 );
    }

    public void play( Board board ) {

        if( map.containsKey( board ));

    }
}
