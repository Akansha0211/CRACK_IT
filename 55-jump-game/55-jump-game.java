class Solution {
    public boolean canJump(int[] nums) {
       return helper(nums, 0, new Boolean[nums.length + 1]);
    }
    public boolean helper(int[] nums, int i, Boolean[] dp) {
        if(i >= nums.length - 1) return true;
        if(dp[i] != null) return dp[i];
        int steps = nums[i];
        for(int j = i + 1; j <= i + steps; j++) {
            if(helper(nums, j, dp) == true) {
                dp[i] = true;
                return true;
            }
        }
        dp[i] = false;
        return false;
    }
}