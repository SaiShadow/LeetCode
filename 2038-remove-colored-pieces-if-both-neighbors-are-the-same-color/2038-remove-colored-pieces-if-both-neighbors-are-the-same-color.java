class Solution {

    public boolean winnerOfGame(String colors) {

        int alice = 0;
        int bob = 0;

        char[] c = colors.toCharArray();
        for (int i = 1; i < c.length - 1; i++) {

            if ((c[i - 1] == c[i] && (c[i + 1] == c[i]))) {

                if (c[i] == 'A') {
                    alice++;
                } else {
                    bob++;
                }
            }

        }
        return alice > bob ? true : false;
    }
}