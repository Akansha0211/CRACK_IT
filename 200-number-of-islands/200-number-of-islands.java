class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && vis[i][j] ==false){
                    dFSonMatrix(i, j,grid.length, grid[0].length, vis, grid);
                    islands++;
                }
            }
        }
        return islands;
    }
    public void dFSonMatrix(int i, int j, int rows, int cols, boolean[][] vis, char[][] grid){
        if(i<0 || j<0 || i>=rows || j>= cols || grid[i][j] =='0' || vis[i][j] == true){
            return;
        }
        vis[i][j] = true;
        //LEFT
        dFSonMatrix(i, j-1, rows, cols, vis, grid);
        //RIGHT
        dFSonMatrix(i, j+1, rows, cols, vis, grid);
        //DOWN
        dFSonMatrix(i+1, j, rows, cols, vis, grid);
        //UP
        dFSonMatrix(i-1, j, rows, cols, vis, grid);
    }
}