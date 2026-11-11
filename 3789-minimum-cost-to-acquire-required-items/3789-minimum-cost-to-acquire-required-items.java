class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long total = 0;
        if (need1 > 0 && need2 > 0) {
            if (costBoth < cost1 + cost2) {
                int min = Math.min(need1, need2);
                total = (long) costBoth * min;
                need1 -= min;
                need2 -= min;
            }
        }
        return total + (long) need1 * Math.min(cost1, costBoth) + (long) need2 * Math.min(cost2, costBoth);
    }
}