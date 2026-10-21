class Solution {
    public int minOperations(String s) {
        int n = s.length();

        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return s.charAt(1) >= s.charAt(0) ? 0 : -1;
        }

        // n >= 3
        // find extrema's positions. 
        char min = s.charAt(0);
        int minIndex = 0;

        char max = s.charAt(0);
        int maxIndex = 0;
        boolean sorted = true;

        for (int i = 1; i < n; i++) {
            char c = s.charAt(i);

            if (c < s.charAt(i - 1)) {
                sorted = false;
            }

            if (c >= max) {
                max = c;
                maxIndex = i;
            }

            if (c < min) {
                min = c;
                minIndex = i;
            }
        }

        if (sorted) {
            return 0;
        }

        if (minIndex == 0 || maxIndex == n - 1) {
            return 1;
        }

        if (minIndex == n - 1 && maxIndex == 0) {
            return 3;
        }

        return 2;
    }
}