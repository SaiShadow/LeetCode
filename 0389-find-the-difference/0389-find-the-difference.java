class Solution {
    public char findTheDifference(String s, String t) {

        if (s.length() == 0) {
            return t.charAt(0);
        }
        
        char[] s_char_arr = s.toCharArray();
        Arrays.sort(s_char_arr);

        char[] t_char_arr = t.toCharArray();
        Arrays.sort(t_char_arr);

        for (int i = 0; i < s_char_arr.length; i++) {

            if (s_char_arr[i] != t_char_arr[i]) {
                return t_char_arr[i];
            }

        }

        return t_char_arr[t.length() - 1];
    }
}