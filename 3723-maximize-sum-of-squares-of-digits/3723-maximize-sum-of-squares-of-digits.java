class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // fill it with 9s if not possible then the lower ones.
        StringBuilder sol = new StringBuilder();

        for (int i = num - 1; i >= 0; i--) {
            if (sum >= 9) {
                sol.append(9);
                sum -= 9;
            } else {
                sol.append(sum);;
                sum = 0;
            }
        }
        if (sum > 0) {
            return "";
        }
        return sol.toString();
    }
}