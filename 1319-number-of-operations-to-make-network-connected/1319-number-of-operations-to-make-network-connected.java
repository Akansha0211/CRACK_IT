class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n>connections.length+1)
            return -1;
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        
        for(int i = 0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            
            // u se v edge
            List<Integer> uNeighbour = graph.getOrDefault(u, new ArrayList<>());
            uNeighbour.add(v);
            graph.put(u, uNeighbour);
            
            // v se u edge
            List<Integer> vNeighbour = graph.getOrDefault(v, new ArrayList<>());
            vNeighbour.add(u);
            graph.put(v, vNeighbour);
        }
        
        // boolean visited[] = new boolean[A];
        Set<Integer> vis = new HashSet<>();
        int components = 0;
        for(int i = 0; i<n; i++){
            if(!vis.contains(i)){
                components++;
                dfs( i,graph, vis);
            }
        }
        return components-1; 
    }
    public static void dfs(int src, HashMap<Integer,List<Integer>> graph, Set<Integer> vis){
        
        // vis[src] = true;
        vis.add(src);
        
        List<Integer> neighbourList = graph.getOrDefault(src, new ArrayList<>());
        for(int neighbour : neighbourList){
            if(!vis.contains(neighbour)){
                dfs(neighbour, graph, vis);
            }
        }       
        
    }
}