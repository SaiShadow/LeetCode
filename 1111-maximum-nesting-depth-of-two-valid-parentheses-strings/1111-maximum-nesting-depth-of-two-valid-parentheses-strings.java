class Solution {
    public int[] maxDepthAfterSplit(String seq) {

        int depthA = 0, depthB = 0;

        int[] sol = new int[seq.length()];
        char[] charArr = seq.toCharArray();

        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] == '(') {
                if(depthA < depthB){
                  // A will take this
                  sol[i] = 0;
                  depthA++;
                } else {
                    sol[i] = 1;
                    depthB++;
                }
            // ')' scenario
            }else {
                if(depthA > depthB){
                    sol[i] = 0;
                    depthA--;
                } else{
                    sol[i] = 1;
                    depthB--;
                }
            }
        }
        return sol;
    }
}