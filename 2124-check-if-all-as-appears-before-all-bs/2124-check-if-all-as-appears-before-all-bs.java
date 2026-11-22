class Solution {
    public boolean checkString(String s) {
        boolean parsedB = false;

        for (char c : s.toCharArray()) {
            if (c == 'b' && !parsedB) {
                parsedB = true;
            }
            if (c == 'a' && parsedB) {
                return false;
            }
        }

        return true;
    }
}