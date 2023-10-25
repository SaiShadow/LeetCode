public class Solution {
    public int kthGrammar(int n, int k) {

        boolean same = true;
        n = 1 << (n - 1);

        while (n != 1) {
            n /= 2;

            if (k > n) {
                k -= n;
                same = !same;
            }
        }
        return (same ? 0 : 1);
    }
}