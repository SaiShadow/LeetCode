class Solution {

    int height;
    int width;
    boolean [][][] visited;

    public boolean hasValidPath(char[][] grid) {
        height = grid.length;
        width = grid[0].length;
        visited = new boolean[height][width][height + width];

        if(grid[0][0] != '(') {
            return false;
        }
        return traverse(grid, 0, 0, 1);
    }

    boolean traverse(char[][] grid, int row, int col, int bracketsStillOpen) {

        if (visited[row][col][bracketsStillOpen]){
            return false;
        } else {
            visited[row][col][bracketsStillOpen] = true;
        }

        if(row == height -1 && col == width -1 ) {
            if(grid[row][col] == ')') {
                return bracketsStillOpen == 0;
            } else {
                return false; 
            }
        }

        boolean valid = moveRight(grid, row, col, bracketsStillOpen);
        if(!valid){ 
            valid = moveDown(grid, row, col, bracketsStillOpen);
        }
        return valid;
    }

    boolean moveRight(char[][] grid, int row, int col, int bracketsStillOpen) {
        int newCol = col + 1;
        if(newCol >= width) return false;
        int newOpenBracketsCount = calcOpenBrackets(grid, row, newCol, bracketsStillOpen);
        if(newOpenBracketsCount < 0) {
            return false;
        }

        return traverse(grid, row, newCol, newOpenBracketsCount);
    }

    boolean moveDown(char[][] grid, int row, int col, int bracketsStillOpen) {
        int newRow = row + 1;
        if(newRow >= height) return false;
        int newOpenBracketsCount = calcOpenBrackets(grid, newRow, col, bracketsStillOpen);
        if(newOpenBracketsCount < 0) {
            return false;
        }

        return traverse(grid, newRow, col, newOpenBracketsCount);
    }

    int calcOpenBrackets(char[][] grid, int row, int col, int bracketsStillOpen) {
        if(grid[row][col] == '('){
            return bracketsStillOpen + 1;
        }else {
            return bracketsStillOpen - 1;
        }
    }
}