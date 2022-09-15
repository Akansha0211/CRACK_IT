class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length; 
        int m = mat[0].length;

        Queue<Integer> q = new LinkedList<>();
        int[][] ans = new int[n][m];
        for(int i = 0; i<n ; i++){
            for(int j = 0; j<m; j++){
                if(mat[i][j] == 0){
                    q.add(i*m+j);
                    ans[i][j] = 0;                    
                }else{
                    ans[i][j] = -1; // marking -1 for unvisited
                }
            }
        }
        
        int level = 0;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int rem  = q.poll();
                int row = rem/m;
                int col = rem%m;
                
                for(int k = 0; k<dir.length; k++){
                    int x = row + dir[k][0];
                    int y = col + dir[k][1];
                    if((x>=0 && x<n) && (y>=0 && y<m) && ans[x][y] == -1){
                        q.add(x*m + y);
                        ans[x][y] = level+1;
                    }
                }
            }
            level++;
        }
        return ans;
    }
}