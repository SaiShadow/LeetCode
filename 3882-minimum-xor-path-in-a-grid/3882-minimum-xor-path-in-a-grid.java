class Solution {
    int rows;
    int columns;
    int[][] grid;
    int sol = Integer.MAX_VALUE;
    boolean[][][] visited;

    public int minCost(int[][] grid) {
        this.rows = grid.length;
        this.columns = grid[0].length;
        this.grid = grid;
        visited = new boolean[rows][columns][1024];
        dfs(0, 0, 0);
        return sol;
    }

    private void dfs(int r, int c, int xor) {
        xor ^= grid[r][c];

        if (visited[r][c][xor]) {
            return;
        } else {
            visited[r][c][xor] = true;
        }

        if (r == rows - 1 && c == columns - 1) {
            sol = Math.min(xor, sol);
            return;
        }

        if (r < rows - 1) {
            // can go down
            dfs(r + 1, c, xor);
        }

        if (c < columns - 1) {
            // can go right
            dfs(r, c + 1, xor);
        }
    }
}