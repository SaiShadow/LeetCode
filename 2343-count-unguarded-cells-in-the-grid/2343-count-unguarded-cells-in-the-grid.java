class Solution {
    private static final int WALL = 3;
    private static final int GUARD = 2;
    private static final int GUARDED = 1;
    private static final int UNGUARDED = 0;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {

        int[][] map = new int[m][n];

        // Mark walls' positions
        for (int[] wall : walls) {
            map[wall[0]][wall[1]] = WALL;
        }

        for (int[] g : guards) {
            int row = g[0];
            int col = g[1];
            map[row][col] = GUARD;
        }
        
        for (int[] g : guards) {
            int row = g[0];
            int col = g[1];
            checkViewFromGuard(map, row, col, m, n);
        }

        int unguarded = 0;
        for (int[] row : map) {
            for (int col : row) {
                if (col == UNGUARDED) unguarded++;
            }
        }
        return unguarded;
    }

    private void checkViewFromGuard(int[][] map, int row, int col, int m, int n) {

        // check left
        for (int c = col - 1; c >= 0; c--) {
            if (map[row][c] == WALL || map[row][c] == GUARD) {
                break;
            }
            map[row][c] = GUARDED;
        }

        // check right
        for (int c = col + 1; c < n; c++) {
            if (map[row][c] == WALL || map[row][c] == GUARD) {
                break;
            }
            map[row][c] = GUARDED;
        }

        // check up
        for (int r = row - 1; r >= 0; r--) {
            if (map[r][col] == GUARD || map[r][col] == WALL) {
                break;
            }
            map[r][col]= GUARDED;
        }

        // check down
        for (int r = row + 1; r < m; r++) {
            if (map[r][col] == GUARD || map[r][col] == WALL) {
                break;
            }
            map[r][col] = GUARDED;
        }
    }
}