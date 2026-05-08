class Solution {
    public String foreignDictionary(String[] words) {
        
        Map<Character, List<Character>> adjList = new HashMap<>();
        for(String word : words) {
            for(char c : word.toCharArray())
                adjList.putIfAbsent(c, new ArrayList<>());
        }
        
        for(int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];

            if (w1.length() > w2.length() && w1.startsWith(w2)) {
                return "";
            }
            
            for(int j = 0; j < Math.min(w1.length(), w2.length()); j++) {

                if(w1.charAt(j) != w2.charAt(j)) {
                    adjList.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        
        int[] inDeg = new int[26];
        Queue<Character> q = new PriorityQueue<>();
        for(Character c : adjList.keySet()) {
            for(Character neighbour : adjList.get(c)) {
                inDeg[neighbour - 'a']++;
            }
        }
        
        for (Character c : adjList.keySet()) {
            if (inDeg[c - 'a'] == 0) {
                q.add(c);
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while(!q.isEmpty()) {
            Character c = q.poll();
            ans.append(c);
            for(Character neig : adjList.get(c)) {
                inDeg[neig - 'a']--;
                if(inDeg[neig - 'a'] == 0) {
                    q.add(neig);
                }
            }
        }
        
        return (ans.length() == adjList.size() ? ans.toString() : "");
    }
}
