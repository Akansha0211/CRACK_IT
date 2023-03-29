class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] ans = new int[n][m];
        
        Queue<Integer> q = new LinkedList<>();
        
        
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(i*m+j);
                    ans[i][j] = 0;
                }else{
                    ans[i][j] = -1;
                }
            }
        }
        
        int level = 0;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int currCell = q.poll();
                int currRow  = currCell / m;
                int currCol = currCell %m;
                
                for(int k = 0; k<dir.length; k++){
                    int row = currRow + dir[k][0];
                    int col = currCol + dir[k][1];
                    
                    if((row>=0 && row<n) && (col>=0 && col<m) && ans[row][col] == -1){
                        // in range and is unvisited
                        q.add(row*m+col);
                        ans[row][col] = level+1;
                    }
                }
            }
            level++;
        }
        
        return ans;
    }
}