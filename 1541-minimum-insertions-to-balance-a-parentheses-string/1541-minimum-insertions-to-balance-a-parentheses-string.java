class Solution {
    public int minInsertions(String s) {
        int open = 0;
        int sol = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                open++;
            } else {
                if (i + 1 < s.length()) {
                    char cNext = s.charAt(i + 1);
                    if (cNext != ')') {
                        sol++;
                    } else {
                        i++;
                    }
                    if (open == 0) {
                        sol++;
                    } else {
                        open--;
                    }
                } else {
                    // out of bounds for i + 1 -> there is ) missing 
                    if (open == 0) {
                        sol += 2; // need to add ( before s[i] and ) after s[i]
                    } else {
                        sol++;
                        open--;
                    }
                }
            }
        }
        return sol + open * 2;
    }
}