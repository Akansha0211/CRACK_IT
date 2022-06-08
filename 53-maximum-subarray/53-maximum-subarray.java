class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1; i<nums.length; i++){
            int prevContri = dp[i-1] + nums[i];
            int newSub = nums[i];
            dp[i] = Math.max(prevContri, newSub);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}