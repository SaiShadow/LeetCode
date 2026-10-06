class Solution {
    public int minAddToMakeValid(String s) {

        int open = 0;
        int changes = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                open++;
            } else {
                if (open <= 0) {
                    changes++;
                } else {
                    open--;
                }
            }
        }

        return open + changes;
    }
}