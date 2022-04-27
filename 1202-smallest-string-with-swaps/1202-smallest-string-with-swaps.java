class Solution {
    
    private void dfs(List<Integer>[] graph, int currVertex, String s, boolean[] visited, List<Character> chs, List<Integer> indexes) {
        if (visited[currVertex]) return;
       
        chs.add(s.charAt(currVertex));
        indexes.add(currVertex);
        
        visited[currVertex] = true;        
        
        for (int neighbor : graph[currVertex]) {
            dfs(graph, neighbor, s, visited, chs, indexes);
        }
    }
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        List<Integer>[] graph = new ArrayList[n];

        for (int i=0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }        
     
        // 0 -> [1]
        // 1 -> [0] 
        
        boolean[] visited = new boolean[n];
        
        for (List<Integer> pair : pairs) {
            int u = pair.get(0);
            int v = pair.get(1);
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        char[] ans = new char[n];
        
        for (int i=0; i < n; i++) {
            if (!visited[i]) {
                List<Character> chs = new ArrayList<>();
                List<Integer> indexes = new ArrayList<>();
                
                dfs(graph, i, s, visited, chs, indexes);
                Collections.sort(chs); // [d c e] -> [c d e]
                Collections.sort(indexes); // [1 0 2] -> [0 1 2]
                
                for (int j=0; j < indexes.size(); j++) {
                    ans[indexes.get(j)] = chs.get(j);
                }
            }
        }
        
        
        return new String(ans);
    }
}