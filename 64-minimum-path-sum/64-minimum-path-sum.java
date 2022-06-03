class Solution {
    public int minPathSum(int[][] grid) {
       
        int n = grid.length;
        int m = grid[0].length;
        
        HashMap<String,Integer> map = new HashMap<>();
        
        return minPathSumHelper(n-1, m-1, grid, map);
    }
    public int minPathSumHelper(int i, int j, int[][]grid, HashMap<String,Integer> map){
        
        if(i == 0 && j == 0)return grid[0][0];
        if(i<0 || j<0)return Integer.MAX_VALUE;
        
        String key = i + "#" + j;
        if(map.containsKey(key))return map.get(key);
        
        int up = minPathSumHelper(i-1, j, grid, map);
        int left = minPathSumHelper(i, j-1, grid, map);
        
        map.put(key, grid[i][j] + Math.min(up, left));
        return grid[i][j] + Math.min(up, left);
    }
}