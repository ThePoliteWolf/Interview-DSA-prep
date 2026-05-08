class Solution {
    int max = 0;
    public int maxProfit(int[] prices) {
        return dfs(0, prices, true);
    }

    public int dfs(int i, int[] prices, boolean buying) {
        if(i >= prices.length) return 0;

        int cooldown = dfs(i + 1, prices, buying);
        if(buying) {
            int buy = dfs(i + 1, prices, false) - prices[i];
            return Math.max(buy, cooldown);
        } else {
            int sell = dfs(i + 2, prices, true) + prices[i];
            return Math.max(sell, cooldown);
        }
    }
}