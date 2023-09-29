class Solution {
    public String decodeAtIndex(String s, int k) {
        // calc length
        long length = 1;
        char c;

        for (int i = 1; i < s.length(); i++) {

            c = s.charAt(i);

            if (Character.isDigit(c)) {
                length *= c - '0';
            } else {
                length++;
            }

        }

        for (int i = s.length() - 1; i >= 0; i--) {

            c = s.charAt(i);
            if (Character.isDigit(c)) {

                length /= c - '0';
                k %= length;

            } else {
                if (k == 0 || k == length) {
                    return c + "";
                }
                length--;
            }

        }
        return "";
    }
}