class Solution {


    public int buyChoco(int[] prices, int money) {
        int index = 0;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min1) {
                min1 = prices[i];
                index = i;
            }
        }
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min2 && i != index) {
                min2 = prices[i];
            }
        }

        return (money >= (min1 + min2)) ? money - min1 - min2 : money;
    }
}