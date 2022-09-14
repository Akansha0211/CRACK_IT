class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer,List<Integer>> adjacencyList = createList(edges);
        boolean[] vis = new boolean[n];
        dfs(source, vis, adjacencyList);
        if(vis[destination] == false)return false;
        return true;
    }
    public void dfs(int source, boolean[] vis, Map<Integer,List<Integer>> adjacencyList){
        vis[source] = true;
        List<Integer> neighbourList = adjacencyList.getOrDefault(source, new ArrayList<>());
        for(int neighbour : neighbourList){
            if(vis[neighbour] == false){
                dfs(neighbour, vis, adjacencyList);
            }
        }
    }
    public Map<Integer,List<Integer>> createList(int[][]edges){
        Map<Integer,List<Integer>> adjacencyList = new HashMap<>();
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            List<Integer> uNeighbourList = adjacencyList.getOrDefault(u, new ArrayList<>());
            uNeighbourList.add(v);
            adjacencyList.put(u, uNeighbourList);
            
            List<Integer> vNeighbour = adjacencyList.getOrDefault(v, new ArrayList<>());
			vNeighbour.add(u);
			adjacencyList.put(v, vNeighbour);
        }
        return adjacencyList;
    }
}