class Solution {
    public int lengthOfLIS(int[] nums) {
        // int[][] dp = new int[nums.length][nums.length+1];
        // for(int[] row : dp){
        //     Arrays.fill(row, -1);
        // }
        // return lisHelper(nums, 0, -1, dp);
        
        int[][] dp  = new int[nums.length+1][nums.length+1];
        int n = nums.length;
        for(int index = n-1; index>=0 ; index--){
            for(int prevIndex = index-1; prevIndex >=-1; prevIndex--){
                int notTake = 0 + dp[index+1][prevIndex+1];
                int take = 0;
                if(prevIndex == -1 || nums[prevIndex] < nums[index]){
                    take = 1 + dp[index+1][index+1];
                }
                dp[index][prevIndex+1] = Math.max(take, notTake);
            }
        }
        return dp[0][-1+1];
    }
   
}