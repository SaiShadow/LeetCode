class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length()!=t.length()) return false;
        if(s.equals(t)) return true;
        
        char[] t_arr = t.toCharArray();
        char[] s_arr = s.toCharArray();

        Arrays.sort(t_arr);
        Arrays.sort(s_arr);

        return Arrays.toString(s_arr).equals(Arrays.toString(t_arr));
    }
}