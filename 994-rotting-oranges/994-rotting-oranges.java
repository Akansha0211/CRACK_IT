class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j});
                }
            }
        }
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int levels = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] rem = q.poll();
                for(int k = 0; k<dir.length; k++){
                    int x = rem[0] + dir[k][0];
                    int y = rem[1] + dir[k][1];
                    if((x>=0 && x<n) && (y>=0 && y<m) && grid[x][y] == 1){
                        q.add(new int[]{x,y}); // now fresh ornage has become a rotten one
                        grid[x][y] = 2;
                    }
                }
            }
            if(!q.isEmpty())levels++;
        }
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1){
                    // any Fresh orange is still remaining
                    return -1;
                }
            }
        }
        return levels;
    }
}