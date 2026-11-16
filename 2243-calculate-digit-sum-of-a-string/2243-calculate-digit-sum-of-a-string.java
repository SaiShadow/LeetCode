class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb = new StringBuilder();
        while (s.length() > k) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (i % k == 0 && i != 0) {
                    sb.append(count);
                    count = 0;
                }
                count += s.charAt(i) - '0';
            }
            sb.append(count);
            s = sb.toString();
            sb = new StringBuilder();
        }

        return s;
    }
}