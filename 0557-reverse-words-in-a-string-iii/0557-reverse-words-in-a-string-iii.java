class Solution {
    public String reverseWords(String s) {

        String x[] = s.split(" ");
        StringBuilder sol = new StringBuilder();

        for (int i = 0; i < x.length; i++) {

            StringBuilder sb = new StringBuilder(x[i]);

            sb.reverse();
            sol.append(sb);

            if (i != x.length - 1) {
                sol.append(" ");
            }
        }
        return sol.toString();
    }
}