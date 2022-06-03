class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        HashMap<String,Integer> map = new HashMap<>();  
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        return mazeHelper(n-1, m-1, obstacleGrid, map);
    }
    
    int mazeHelper(int i, int j,int[][] mat,HashMap<String,Integer> map){
        if(i<0 || j<0 || mat[i][j] == 1)return 0;
        if(i == 0 && j== 0)return 1;
        
        String key = i + "#" + j;
        if(map.containsKey(key))return map.get(key);
        
        int up = mazeHelper(i-1, j,mat, map);
        int left = mazeHelper(i, j-1, mat, map);
        
        // int mod = 1000000007;
        map.put(key, up+left);
        return map.get(key);
    }
}