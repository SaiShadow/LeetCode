class Solution {
    public int countServers(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // calculate how many servers per row and column
        int[] serversInRow = new int[grid.length];
        int[] serversInCol = new int[grid[0].length];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    serversInRow[r]++;
                    serversInCol[c]++;
                }
            }
        }

        // count all servers that are in a row or column that have more than 2 servers
        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1 &&
                        (serversInRow[r] >= 2 || serversInCol[c] >= 2)) {
                    count++;
                }
            }
        }

        return count;
    }
}