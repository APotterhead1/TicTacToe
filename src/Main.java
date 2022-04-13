import TicTacToe.*;
import TicTacToe.AI.*;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Game game = new Game( 2 );

        AI ai = new AI();

        Board board1 = new Board();
        Board board2 = new Board();

        Map map = new HashMap<Integer, Integer>();

        ai.map.put(board1, map);

        ai.play( board2 );
    }
}
