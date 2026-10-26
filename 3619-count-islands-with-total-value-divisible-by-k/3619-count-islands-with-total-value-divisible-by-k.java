class Solution {
    int rows;
    int columns;
    boolean[][] visited;

    public int countIslands(int[][] grid, int k) {
        rows = grid.length;
        columns = grid[0].length;
        int islands = 0;
        visited = new boolean[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (canSkip(r, c, grid)) {
                    continue;
                }

                long islandSum = dfs(r, c, grid);
                if (islandSum > 0 && islandSum % k == 0) {
                    islands++;
                }
            }
        }
        return islands;
    }

    private boolean canSkip(int r, int c, int[][] grid) {
        return (grid[r][c] == 0 || visited[r][c]);
    }

    private long dfs(int r, int c, int[][] grid) {
        if (r < 0 || r >= rows || c < 0 || c >= columns) {
            return 0;
        }

        if (canSkip(r, c, grid)) {
            return 0;
        }

        visited[r][c] = true;

        long left = dfs(r, c - 1, grid);
        long right = dfs(r, c + 1, grid);
        long up = dfs(r - 1, c, grid);
        long down = dfs(r + 1, c, grid);

        return grid[r][c] + left + right + up + down;
    }
}