public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        boolean[] exists = new boolean[51];
        int[] C = new int[A.length];
        int common = 0;

        for (int i = 0; i < C.length; i++) {
            if (exists[A[i]]) {
                common++;
            } else {
                exists[A[i]] = true;
            }
            if (exists[B[i]]) {
                common++;
            } else {
                exists[B[i]] = true;
            }
            C[i] = common;
        }
        return C;
    }
}