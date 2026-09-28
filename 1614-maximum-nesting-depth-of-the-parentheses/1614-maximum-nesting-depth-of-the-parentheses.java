class Solution {
    public int maxDepth(String s) {

        char[] charArr = s.toCharArray();
        int maxDepth = 0;
        int currDepth = 0;

        for(char c : charArr) {

            if(c == '(') {
                currDepth++;
                maxDepth = currDepth > maxDepth ? currDepth : maxDepth;
            } else if(c == ')') {
                currDepth--;
            }
        }
        
        return maxDepth;
    }
}