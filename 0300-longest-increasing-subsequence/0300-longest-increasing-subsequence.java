class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int[][] dp  = new int[nums.length+1][nums.length+1];
        int n = nums.length;
        for(int index = n-1; index>=0 ; index--){
            for(int prevIndex = index-1; prevIndex >=-1; prevIndex--){
                int len = 0 + dp[index+1][prevIndex+1];
                if(prevIndex == -1 || nums[prevIndex] < nums[index]){
                    len = Math.max(len, 1 + dp[index+1][index+1]);
                }
                dp[index][prevIndex+1] = len;
            }
        }
        return dp[0][-1+1];
    }
   
}