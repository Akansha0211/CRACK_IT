class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum+=num;
        }
        if(totalSum %2 != 0)return false;
        int target = totalSum/2;
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return subsetSumTargetHelper(0, target, nums,dp);
    }
    public static boolean subsetSumTargetHelper(int index , int target, int[] nums, int[][] dp){
        
        if(target == 0)return true;
        if(index>=nums.length && target != 0)return false;
        if(dp[index][target] != -1)return dp[index][target]==1 ? true:false;
        boolean take = false;
        if(target >= nums[index]){
            take = subsetSumTargetHelper(index+1, target - nums[index], nums, dp);
        }
        boolean dontTake = false;
        if(take == false){
            dontTake = subsetSumTargetHelper(index+1, target, nums, dp);
        }
        // map.put(key, (take || dontTake));
        dp[index][target] = (take || dontTake) ? 1:0;
        return (take || dontTake);
    }
    
}