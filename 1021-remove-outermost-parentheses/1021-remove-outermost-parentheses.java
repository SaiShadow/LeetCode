class Solution {
    public String removeOuterParentheses(String s) {
        String sol = "";
        int open = 0;

        for (char c : s.toCharArray()) {
            if(c == '(') {
                if (open != 0) {
                    sol += c;
                }
                open++;
            } else {
                open--;
                if (open != 0) {
                    sol += c;
                }
            }
        }
        return sol;
    }
}