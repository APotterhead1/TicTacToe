package TicTacToe;

public class Board implements Comparable {
    public Space[][] board04 = new Space[3][3];

    public Board() {

        for(int i = 0; i < board04.length; i++ )
            for(int j = 0; j < board04[i].length; j++ )
                board04[i][j] = new Space();
    }

    public Board( Board oldBoard ) {

        for( int i = 0; i < 3; i++ ) {
            for( int j = 0; j < 3; j++ ) {

                board04[i][j] = oldBoard.board04[i][j];
            }
        }
    }

    public int checkIfGameOver() {

        for(int i = 0; i < board04.length; i++ )
            if( board04[i][0].value == board04[i][1].value && board04[i][0].value == board04[i][2].value && board04[i][0].value != ' ' ) {
                if (board04[i][0].value == 'O') return 1;
                return -1;
            }

        for(int i = 0; i < board04.length; i++ )
            if( board04[0][i].value == board04[1][i].value && board04[0][i].value == board04[2][i].value && board04[0][i].value != ' ' ) {
                if (board04[0][i].value == 'O') return 1;
                return -1;
            }

        if( board04[0][0].value == board04[1][1].value && board04[0][0].value == board04[2][2].value && board04[0][0].value != ' ' ) {
            if( board04[0][0].value == 'O') return 1;
            return -1;
        }

        if( board04[0][2].value == board04[1][1].value && board04[0][2].value == board04[2][0].value && board04[0][2].value != ' ' ) {
            if( board04[0][2].value == 'O' ) return 1;
            return -1;
        }

        for(int i = 0; i < board04.length; i++ )
            for(int j = 0; j < board04[ i ].length; j++ )
                if( board04[i][j].value == ' ' ) return 2;
        return 0;
    }

    public String toString() {

        String str = "" + board04[0][0] + '|' + board04[0][1] + '|' + board04[0][2];
        str += "\n---|---|---\n" + board04[1][0] + '|' + board04[1][1] + '|' + board04[1][2];
        str += "\n---|---|---\n" + board04[2][0] + '|' + board04[2][1] + '|' + board04[2][2];
        return str;
    }

    public int compareTo(Object o) {

        Board b = (Board) o;

        return toString().compareTo( b.toString() );
    }

    public boolean equals(Object o) {

        Board b = (Board) o;

        for(int i = 0; i < board04.length; i++ ) {
            for(int j = 0; j < board04[i].length; j++ ) {
                if( board04[i][j].value != b.board04[i][j].value ) return false;
            }
        }
        return true;
    }
}
