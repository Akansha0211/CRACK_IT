class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return lIS(0, -1, nums, nums.length, dp);
    }
    public int lIS(int index, int prev_index, int[] nums, int n, int[][] dp){
        if(index == n)return 0;
        if(dp[index][prev_index+1]!= -1)return dp[index][prev_index+1];
        int len = lIS(index+1, prev_index, nums, n, dp);
        //int take = 0;
        if(prev_index == -1 || nums[index] > nums[prev_index]){
            len = Math.max(len, 1+lIS(index+1, index, nums, n, dp));
        }
        dp[index][prev_index+1] = len;
        return len;
    }
}