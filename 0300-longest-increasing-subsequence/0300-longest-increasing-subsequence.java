class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return lisHelper(nums, 0, -1, dp);
    }
    public int lisHelper(int[] nums, int index, int prevIndex, int[][] dp){
        if(index == nums.length)return 0;
        if(dp[index][prevIndex+1] != -1)return dp[index][prevIndex+1];
        int notTake = lisHelper(nums, index+1, prevIndex, dp);
        int take = 0;
        if(prevIndex == -1 || nums[prevIndex] < nums[index]){
            take = 1+ lisHelper(nums, index+1, index, dp);
        }
        dp[index][prevIndex+1] = Math.max(take , notTake);
        return Math.max(take, notTake);
    }
}