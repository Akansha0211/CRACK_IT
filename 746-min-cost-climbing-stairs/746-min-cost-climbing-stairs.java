class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(minCostHelper(cost, 0, cost.length, dp),minCostHelper(cost,1 , cost.length, dp));
    }
    public int minCostHelper(int[] cost, int index, int n, int[] dp){
        if(index>=n)return 0;
        if(dp[index] != -1)return dp[index];
        int choice1 = cost[index] + minCostHelper(cost, index+1, n, dp);
        int choice2 = cost[index] + minCostHelper(cost, index+2, n, dp);
        return dp[index] =  Math.min(choice1, choice2);
    }
}