class Solution {
    public boolean canAliceWin(int n) {
        boolean alice = false;

        for (int i = 10; i > 0; i--) {
            if(i > n) {
                return alice;
            }
            n = n - i;
            alice = !alice;
        }

        return alice;
    }
}