
class Solution {
     int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
       
        int n = grid.length;
        int m = grid[0].length;
        
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1)return -1;
        boolean[][] vis = new boolean[n][m];
        vis[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] pop = q.poll();
                if(pop[0] == n-1 && pop[1] == m-1)return (level +1);
                for(int k = 0; k<dir.length; k++){
                    int x = pop[0] + dir[k][0];
                    int y = pop[1] + dir[k][1];
                    if((x>=0 && x<n) &&(y>=0 && y<m) && !vis[x][y] && grid[x][y] == 0){
                        q.add(new int[]{x,y});
                        vis[x][y] = true;
                        
                    }
                }
            }
            level++;
        }
        return -1;
    }
}