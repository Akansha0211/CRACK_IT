class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        
        for(int j = 0; j<=m; j++) dp[0][j] = 0;
        for(int i = 0; i<=n; i++) dp[i][0] = 0;
        
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m ; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] =  1 + dp[i-1][j-1];
                }
                else{
                    int choice1 = dp[i][j-1];
                    int choice2 = dp[i-1][j];
                
                    dp[i][j] =  Math.max(choice1, choice2);
                }
            }
        }
        return dp[n][m];
        
    }
    public int lcsHelper(int i ,int j, String s1, String s2, HashMap<String,Integer> map){
        
        if(i==0 || j==0)return 0;
        String key = Integer.toString(i) + "#" + Integer.toString(j);
        if(map.containsKey(key))return map.get(key);
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return 1 + lcsHelper(i-1, j-1, s1, s2, map);
        }
        int choice1 = lcsHelper(i, j-1, s1, s2, map);
        int choice2 = lcsHelper(i-1, j, s1, s2, map);
        map.put(key, Math.max(choice1, choice2));
        return Math.max(choice1, choice2);
    }
    
}