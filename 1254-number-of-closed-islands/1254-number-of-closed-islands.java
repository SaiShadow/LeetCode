class Solution {
    int rows;
    int columns;
    boolean[][] visited;

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        int islands = 0;
        visited = new boolean[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (canSkip(r, c, grid))
                    continue;

                if (dfs(r, c, grid)) {
                    islands++;
                }
            }
        }
        return islands;
    }

    private boolean canSkip(int r, int c, int[][] grid) {
        return (grid[r][c] == 1 || visited[r][c]);
    }

    private boolean dfs(int r, int c,int[][] grid) {
        if (r < 0 || r >= rows || c < 0 || c >= columns) {
            return false;
        }

        if (canSkip(r, c, grid)) {
            return true;
        }

        visited[r][c] = true;

        boolean left = dfs(r, c - 1, grid);
        boolean right = dfs(r, c + 1, grid);
        boolean up = dfs(r - 1, c, grid);
        boolean down = dfs(r + 1, c, grid);

        return left && right && up && down;
    }
}