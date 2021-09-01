package lession3.homework;

/**
 * 130. 被围绕的区域
 */
public class Lc130_Solve {

    /**
     * 搜索，从最外边四条线开始搜索，如果有'O'则替换成'#',沿四个方向 dfs
     * 遍历把 O 替换成 X，# 替换成 O 得到结果
     *
     * @param board
     */
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                boolean isEdge = row == 0 || row == m - 1 || col == 0 || col == n - 1;
                if (isEdge && board[row][col] == 'O') {
                    dfs(board, row, col);
                }
            }
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 'O') board[row][col] = 'X';
                if (board[row][col] == '#') board[row][col] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        }
        board[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(board, nx, ny);
        }
    }

    int m;
    int n;
    private int[] dx = {1, 0, -1, 0};//右，下，左，上
    private int[] dy = {0, 1, 0, -1};
}
