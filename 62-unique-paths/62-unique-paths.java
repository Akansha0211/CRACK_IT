class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String,Integer> map = new HashMap<>();
        return uniquePathsHelper(0, 0, m, n, map);
    }
    public int uniquePathsHelper(int i, int j, int m, int n, HashMap<String,Integer> map){
        if(i>=m || j>=n)return 0;
        if(i == m-1 && j == n-1)return 1;
        String key = i + "#" + j;
        if(map.containsKey(key))return map.get(key);
        int down = uniquePathsHelper(i+1, j, m, n, map);
        int right = uniquePathsHelper(i,j+1, m, n, map);
        map.put(key, down+right);
        return down + right;
    }
}