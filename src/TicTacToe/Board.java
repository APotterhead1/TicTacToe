package TicTacToe;

public class Board {
    public Space[][] board = new Space[3][3];

    public Board() {

        for( int i = 0; i < board.length; i++ )
            for( int j = 0; j < board[i].length; j++ )
                board[i][j] = new Space();
    }

    public int checkIfGameOver() {

        for( int i = 0; i < board.length; i++ )
            if( board[i][0].value == board[i][1].value && board[i][0].value == board[i][2].value ) {
                if (board[i][0].value == '0') return 1;
                else return -1;
            }

        for( int i = 0; i < board.length; i++ )
            if( board[0][i].value == board[1][i].value && board[0][i].value == board[2][i].value ) {
                if (board[i][0].value == '0') return 1;
                else return -1;
            }

        for( int i = 0; i < board.length; i++ )
            for( int j = 0; j < board.length; j++ )
                if( board[i][j].value == ' ' ) return 2;
        return 0;
    }

    public String toString() {

        String str = "" + board[0][0] + '|' + board[0][1] + '|' + board[0][2];
        str += "\n---|---|---\n" + board[1][0] + '|' + board[1][1] + '|' + board[1][2];
        str += "\n---|---|---\n" + board[2][0] + '|' + board[2][1] + '|' + board[2][2];
        return str;
    }
}
