public class Solution {
    public int minSteps(String s, String t) {
        int[] s_inArray = new int[26];
        int[] t_inArray = new int[26];

        for (char ch : s.toCharArray()) {
            s_inArray[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            t_inArray[ch - 'a']++;
        }

        int howMany = 0;
        for (int i = 0; i < 26; i++) {
            howMany += Math.abs(s_inArray[i] - t_inArray[i]);
        }

        return howMany / 2;  
    }
}