class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // bucket sort logic
        // Have freq map to count of each number.
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.putIfAbsent(x, 0);
            freq.put(x, freq.get(x) + 1);
        }

        // index will be count in this bucket and values will be number of array having that count.
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : freq.keySet()) {
            int count = freq.get(key);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<>();;
            }
            buckets[count].add(key);
        }

        int[] ans = new int[k];
        int idx = 0;
        // get k elements from last as we need k maximum freq element..
        for(int i = nums.length; i > -1 && k > 0; i--) {
            if(buckets[i] != null) {
                for(int j = 0; j < buckets[i].size() && k > 0; j++) {
                    ans[idx++] = buckets[i].get(j);
                    k--;
                }
            }
        }
        return ans;
    }
}