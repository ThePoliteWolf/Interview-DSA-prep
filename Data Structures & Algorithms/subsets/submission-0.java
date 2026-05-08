class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums, ans);
        return ans;
    }

    public void dfs(int i, List<Integer> subset, int[] nums, List<List<Integer>> ans) {
        if(i >= nums.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i + 1, subset, nums, ans);

        subset.remove(subset.size() - 1);
        dfs(i + 1, subset, nums, ans);
    }
}
