class Solution {
    public static double champagneTower(int poured, int query_row, int query_glass) {

        double[][] glasses = new double[query_row + 1][query_row + 1];
        glasses[0][0] = poured;

        for (int i = 0; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                
                pour(glasses, i, j, query_row);
            }
        }

        return glasses[query_row][query_glass];
    }

    private static void pour(double[][] glasses, int i, int j, int query_row) {

        if (glasses[i][j] <= 1) {
            return;
        }

        if (i < query_row) {
            double a = (glasses[i][j] - 1) / 2;

            glasses[i + 1][j] += a;
            glasses[i + 1][j + 1] += a;
        }

        glasses[i][j] = 1;
    }
}