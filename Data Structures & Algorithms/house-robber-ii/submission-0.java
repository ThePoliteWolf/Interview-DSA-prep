class Solution {
     public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(solve(nums, 0, nums.length - 1), solve(nums, 1, nums.length));
    }
    
    public int solve(int[] nums, int index, int end) {
        int dp[] = new int[nums.length];
        dp[index] = nums[index];
        dp[index + 1] = Math.max(nums[index], nums[index + 1]);
        for(int i = index + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end - 1];
    }
}
