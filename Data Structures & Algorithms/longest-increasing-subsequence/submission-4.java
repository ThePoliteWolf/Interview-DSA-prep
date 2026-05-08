class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) 
            return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
