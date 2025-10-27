class Solution {

    public int numberOfBeams(String[] bank) {

        int secInPrevRow = 0;
        int lasers = 0;

        for (String row : bank) {

            int secCurrRow = numOfOnes(row);

            if (secCurrRow == 0)
                continue;

            if (secInPrevRow == 0) {
                secInPrevRow = secCurrRow;
                continue;
            }

            lasers += secCurrRow * secInPrevRow;
            secInPrevRow = secCurrRow;

        }
        return lasers;
    }

    private int numOfOnes(String row) {
        int ones = 0;
        for (char c : row.toCharArray()){
            if (c == '1')
                ones++; 
        }
        return ones;
    }
}