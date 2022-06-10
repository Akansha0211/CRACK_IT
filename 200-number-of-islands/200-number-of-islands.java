class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        
        int islands = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    dfsOnMatrix(i, j, vis, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dfsOnMatrix(int i, int j , boolean[][] vis, char[][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || vis[i][j] == true || grid[i][j] == '0'){
            return;
        }
        vis[i][j] = true;
        // left
        dfsOnMatrix(i, j-1, vis, grid);
        // right
        dfsOnMatrix(i, j+1, vis, grid);
        // up
        dfsOnMatrix(i-1, j, vis, grid);
        //down
        dfsOnMatrix(i+1, j, vis, grid);
        
    }
}