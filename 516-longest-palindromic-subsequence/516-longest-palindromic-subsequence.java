class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String rev = sb.toString();
        
        int len = s.length();
        int revLen = rev.length();
        
        int[][] dp =new int[len][revLen];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return lcsHelper(0, 0, s, rev, dp);
    }
    public int lcsHelper(int i, int j , String s, String rev, int[][] dp){
        
        if(i>= s.length() || j>= rev.length())return 0;
        //String key = Integer.toString(i) + "#" + Integer.toString(j);
       
        if(dp[i][j] != -1)return dp[i][j];
        
        if(s.charAt(i) == rev.charAt(j)){
            return dp[i][j] =  1 + lcsHelper(i+1, j+1, s, rev, dp);
        }
        int choice1 = lcsHelper(i, j+1, s, rev, dp);
        int choice2 = lcsHelper(i+1, j, s, rev, dp);
        
        return dp[i][j] =  Math.max(choice1, choice2);
        
    }
   
}