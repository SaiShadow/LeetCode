class Solution {
    public int minCost(String colors, int[] neededTime) {
        char[] colorArray = colors.toCharArray();
        if (colorArray.length <= 1) {
            return 0;
        }

        int cost = 0;
        int currMaxCost = 0;
        boolean prevSame = false;
        int costInGroup = 0;

        for (int i = 1; i < colorArray.length; i++) {
            char curr = colorArray[i];
            char prev = colorArray[i - 1];

            if (curr == prev) {
                if (prevSame) {
                    currMaxCost = Math.max(currMaxCost, neededTime[i]);
                    costInGroup += neededTime[i];
                } else {
                    prevSame = true;
                    currMaxCost = Math.max(neededTime[i - 1], neededTime[i]);
                    costInGroup += neededTime[i] + neededTime[i - 1];
                }
            } else {
                if (prevSame) {
                    cost += costInGroup - currMaxCost;
                    costInGroup = 0;
                    prevSame = false;
                    currMaxCost = 0;
                }
            }
        }
        if (prevSame) {
            cost += costInGroup - currMaxCost;
        }
        return cost;
    }
}