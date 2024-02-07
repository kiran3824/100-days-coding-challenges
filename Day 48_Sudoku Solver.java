class Solution {
    public void solveSudoku(char[][] board) {
        int n = board.length;
        solveboard(board, n);
    }

    boolean notclash(int num, int i, int j, char[][] board, int n) {
        for (int k = 0; k < n; k++) {
            if (board[i][k] == num + '0')
                return false;
            if (board[k][j] == num + '0')
                return false;
        }

        int s = (int) Math.sqrt(n);
        int startrow = i - i % s;
        int startcol = j - j % s;

        for (int r = startrow; r < startrow + s; r++) {
            for (int c = startcol; c < startcol + s; c++) {
                if (board[r][c] == num + '0')
                    return false;
            }
        }
        return true;
    }

    boolean solveboard(char[][] board, int n) {
        int i, j = -1; // Initialize j to -1
        boolean flag = false;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        if (i == n && j == n)
            return true;

        for (int num = 1; num <= n; num++) {
            if (notclash(num, i, j, board, n)) {
                board[i][j] = (char) (num + '0');
                if (solveboard(board, n))
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
    }
}
