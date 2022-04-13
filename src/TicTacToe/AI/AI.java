package TicTacToe.AI;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.Map;
import TicTacToe.*;

public class AI {

    public Map<Board, Double> map;

    public AI() {

        try {
            File file = new File("ai.dat");
            file.createNewFile();

            Scanner scanner = new Scanner( file );

            while( scanner.hasNext() ) {

                double chance = scanner.nextDouble();

                String str = scanner.nextLine();

                String[] spaces = str.split("\\s+");

                Board board = new Board();

                int spacesLength

                for( int i = 0; i < board.board.length; i++ ) {

                    for( int j = 0; j < board.board[i].length; j++ ) {
                        if( board.board[i][j] =
                    }
                }

            }

        } catch( IOException e ) {}
    }

    public void train( int success ) {

        if( success == 0 ) return;
        if( success == 1 );
        if( success == -1 );
    }
}
