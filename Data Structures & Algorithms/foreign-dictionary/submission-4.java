class Solution {
    public String foreignDictionary(String[] words) {
      Set<Character> noc = new HashSet<>();
        for(int i = 0; i < words.length; i++) {
            String word = words[i];
            for(int j = 0; j < word.length(); j++) {
                noc.add(word.charAt(j));
            }
        }
        
        Map<Character, List<Character>> adjList = new HashMap<>();
        for(Character c : noc) {
            adjList.put(c, new ArrayList<>());
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
        Queue<Character> q = new LinkedList<>();
        for(Character c : adjList.keySet()) {
            for(Character neighbour : adjList.get(c)) {
                inDeg[neighbour - 'a']++;
            }
        }
        
        for(int i = 0; i < 26; i++) {
            if(inDeg[i] == 0 && noc.contains((char)(i + 'a'))) {
                q.add((char)(i + 'a'));
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
        
        return (ans.length() == noc.size() ? ans.toString() : "");
    }
}
