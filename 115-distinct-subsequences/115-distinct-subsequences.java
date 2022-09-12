class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return distinctSubHelper(0,0, s, t, dp);
    }
    public static int distinctSubHelper(int i, int j, String s1, String s2, int[][]dp){
        if(j>=s2.length())return 1;
        if(i>=s1.length())return 0;
        if(dp[i][j] !=-1)return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            int choice1 = distinctSubHelper(i+1, j+1, s1 , s2, dp);
            int choice2 = distinctSubHelper(i+1, j, s1, s2, dp);
            return dp[i][j] =  choice1 + choice2;
        }
        return dp[i][j] =  distinctSubHelper(i+1, j, s1, s2, dp);
    }
    
}