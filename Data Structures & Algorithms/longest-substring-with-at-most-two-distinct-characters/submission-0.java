class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;

        while(end < s.length()) {
            char curr = s.charAt(end);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            while(map.size() > 2) {
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);
                if(map.get(startChar) == 0) {
                    map.remove(startChar);
                }
                start++;
            }
            maxLen = Math.max(end - start + 1, maxLen);
            end++;
        }
        return maxLen;
    }
}