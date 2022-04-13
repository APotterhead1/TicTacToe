package TicTacToe.AI;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import TicTacToe.*;

public class AI {

    public Map<Board, Map<Integer, Double>> map;

    public AI() {

        try {
            File file = new File("ai.dat");
            file.createNewFile();

            Scanner scanner = new Scanner( file );

            while( scanner.hasNext() ) {

                double[] chances = new double[9];

                for( int i = 0; i < chances.length; i++ ) chances[i] = scanner.nextDouble();

                String str = scanner.nextLine();

                String[] spaces = str.split("\\s+");

                Board board = new Board();

                int index = 0;

                for( int i = 0; i < board.board.length; i++ ) {
                    for( int j = 0; j < board.board[i].length; j++ ) {

                        board.board[i][j].value = spaces[index].charAt( 0 );
                    }
                }

                Map<Integer, Double> map1 = new TreeMap<Integer, Double>();

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
}
