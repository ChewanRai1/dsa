import java.util.ArrayList;
import java.util.List;

public class Nqueens {

    public static boolean isSafe(int row, int col, char[][] board) {
        // cheacking fpr horizontal
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // checking for vertical position

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // moving diagonally upper left from the position row,col
        int r = row;
        for (int c = col; r >= 0 && c >= 0 && r < board.length && c < board.length; r--, col--) {
            if (board[r][c] == 'Q') {
                return false;
            }

        }

        // moving diagonally upper right from the position
        r = row;
        for (int c = col; r >= 0 && c >= 0 && r < board.length && c < board.length; r--, col--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        // moving diagonally lower right from the position
        r = row;
        for (int c = col; r >= 0 && c >= 0 && r < board.length && c < board.length; r--, col--) {
            if (board[r][c] == 'Q') {
                return false;
            }

        }

        // moving diagonally lower left from the position
        r = row;
        for (int c = col; r >= 0 && c >= 0 && r < board.length && c < board.length; r--, col--) {
            if (board[r][c] == 'Q') {
                return false;
            }
        }

        return true;

    }

    public static void savesoln(char[][] board, List<List<String>> solnlist) {

    }

    public static void helper(char[][] board, int col, List<List<String>> solnlist) {
        if (col == board.length) {
            savesoln(board, solnlist);
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                helper(board, col + 1, solnlist);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        List<List<String>> solnlist = new ArrayList<>(null);

    }
}