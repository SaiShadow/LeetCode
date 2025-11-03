class Solution {
    public int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int maxTime = neededTime[0];
        int sum = neededTime[0];

        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                sum += neededTime[i];
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                cost += sum - maxTime;
                sum = neededTime[i];
                maxTime = neededTime[i];
            }
        }

        cost += sum - maxTime;
        return cost;
    }
}
