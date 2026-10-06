class Solution {
    public int minAddToMakeValid(String s) {

        int open = 0;
        int changes = 0;
        
        for(char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open <= 0) {
                    changes++;
                }else {
                    open--;
                }
            }
        }

        return open + changes;
    }
}