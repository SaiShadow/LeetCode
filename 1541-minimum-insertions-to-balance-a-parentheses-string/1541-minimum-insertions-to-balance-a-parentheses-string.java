class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int sol = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    sol++;
                }
                if (open == 0) {
                    sol++;
                } else {
                    open--;
                }
            }
        }
        return sol + open * 2;
    }
}