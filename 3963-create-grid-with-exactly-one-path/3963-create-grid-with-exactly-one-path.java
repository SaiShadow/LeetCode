class Solution {
    public String[] createGrid(int m, int n) {
        String[] sol = new String[m];
        for (int r = 0; r < m; r++) {
            StringBuilder sb = new StringBuilder();

            for (int c = 0; c < n; c++) {
                if (r == 0 || c == n - 1) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sol[r] = sb.toString();
        }
        return sol;
    }
}