class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return minOpnHelper(0, 0, word1, word2, dp);
    }
    public static int minOpnHelper(int i, int j, String s1, String s2, int[][] dp){
        
        if(i>=s1.length())return s2.length() - j;
        if(j>=s2.length())return s1.length() - i;
        if(dp[i][j] != -1)return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = minOpnHelper(i+1, j+1, s1, s2, dp);
        }
        int insertion = 1 + minOpnHelper(i, j+1, s1, s2, dp);
        int deletion = 1 + minOpnHelper(i+1, j, s1, s2, dp);
        int replace = 1 + minOpnHelper(i+1, j+1, s1, s2, dp);
        return dp[i][j] =  Math.min(insertion, Math.min(deletion,replace));
    }
}