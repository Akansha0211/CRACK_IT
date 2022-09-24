class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int V = isConnected.length; // 1 2 3 here for eg
        
        for(int i = 0; i<V; i++){
            adjList.add(new ArrayList<Integer>());
        }
        
        // to chnage matrix to adjList
        for(int i = 0; i<V; i++){
            for(int j = 0; j<V; j++){
                if(isConnected[i][j] == 1 && i!=j){
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int[] visited = new int[V];
        int cnt = 0;
        for(int i = 0; i<V; i++){
            if(visited[i] == 0){
                cnt++;
                dfs(i, adjList, visited);
            }
        }
        return cnt;
    }    
    
    public void dfs(int node,  ArrayList<ArrayList<Integer>> adjList, int[] visited){
        visited[node] = 1;
        for(int i : adjList.get(node)){
            if(visited[i] == 0){
                dfs(i, adjList, visited);
            }
        }
    }
}