class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        int n = mat.length;
        int m = mat[0].length;
        
        int[][] ans = new int[mat.length][mat[0].length];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i= 0; i<mat.length; i++){
            for(int j = 0; j<mat[0].length; j++){
                if(mat[i][j] == 0){
                    q.add(i*m+j);
                    ans[i][j] = 0;
                }else ans[i][j] = -1;
            }
        }
        
        int level = 0;
        int[][] dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        
        
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int currCell = q.poll();
                int r = currCell /m;
                int c = currCell %m;
                
                for(int k = 0; k<dir.length; k++){
                    int nr = r + dir[k][0];
                    int nc = c + dir[k][1];
                    if(nr >= 0 && nc >=0 && nr <n && nc <m  && ans[nr][nc]== -1){
                        q.add(nr*m + nc);
                        ans[nr][nc] = level + 1;
                    }
                }
            }
            level++;
        }
        return ans;
        
    }
}