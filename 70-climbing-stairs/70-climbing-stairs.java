class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsHelper(n, dp);
    }
    public int climbStairsHelper(int n, int[] dp){
        if(n == 0)return 1;
        if(n==1) return 1;
        if(dp[n] != -1)return dp[n];
        return dp[n] =  climbStairsHelper(n-1, dp) + climbStairsHelper(n-2, dp);
    }
}