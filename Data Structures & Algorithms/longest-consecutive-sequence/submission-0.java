class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);

        int ans = 0;
        int i = 0;
        while(i < nums.length) {
            int currentNum = nums[i];
            int count = 0;
            if(!set.contains(currentNum - 1)) {
                while(set.contains(currentNum)) {
                    currentNum++;
                    count++;
                }
            }
            ans = Math.max(count, ans);
            i++;
        }
        return ans;
    }
}
