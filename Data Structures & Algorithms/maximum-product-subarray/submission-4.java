class Solution {
    public int maxProduct(int[] nums) {
        int[] min_dp = new int[nums.length];
        int[] max_dp = new int[nums.length];
        min_dp[0] = nums[0];
        max_dp[0] = nums[0];

        int max = nums[0];

        for(int i = 1; i < nums.length; i++) {
            int p1 = min_dp[i - 1] * nums[i];
            int p2 = max_dp[i - 1] * nums[i];

            min_dp[i] = Math.min(Math.min(p1, p2), nums[i]);
            max_dp[i] = Math.max(Math.max(p1, p2), nums[i]);
            max = Math.max(Math.max(max, max_dp[i]), min_dp[i]);
        }
        return max;

    }
}
