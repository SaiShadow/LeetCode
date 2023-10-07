class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int[] max = new int[prices.length];

        for (int i = prices.length -1; i >=0; i--) {
            profit = Math.max(profit, prices[i]);
            max[i] = profit;
        }

        profit = 0;

        for (int i = 0; i < prices.length; i++) {
            profit = Math.max(profit, max[i] - prices[i]);
        }

        return profit;
    }
}