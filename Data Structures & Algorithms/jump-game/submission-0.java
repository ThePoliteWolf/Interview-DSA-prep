class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for(int i = 0; i < nums.length; i++) {

            // cannot even reach this index
            if(i > farthest) {
                return false;
            }

            // extend reachable range
            farthest = Math.max(farthest, i + nums[i]);

            // already can reach end
            if(farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}
