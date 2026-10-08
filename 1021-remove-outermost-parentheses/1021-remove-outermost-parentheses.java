class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sol = new StringBuilder();
        int open = 0;

        for (char c : s.toCharArray()) {
            if(c == '(') {
                if (open != 0) {
                    sol.append(c);
                }
                open++;
            } else {
                open--;
                if (open != 0) {
                    sol.append(c);
                }
            }
        }
        return sol.toString();
    }
}