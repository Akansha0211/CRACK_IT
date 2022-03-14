class Solution {
    public boolean canJump(int[] nums) {
      // Map<Integer,Boolean> map = new HashMap<>();
        Boolean[] dp = new Boolean[nums.length+1];
      return canJumpHelper(nums, 0, dp);
    }
    public boolean canJumpHelper(int[]nums, int i, Boolean[] dp){
        if(i >= nums.length - 1) return true;
        // if(map.containsKey(i)) return map.get(i);
        if(dp[i] != null)return dp[i];
        int steps = nums[i];
        for(int j = i + 1; j <= i + steps; j++) {
            if(canJumpHelper(nums, j, dp) == true) {
                dp[i] = true;
                // map.put(i, true);
                return true;
            }
        }
        dp[i] = false;
        // map.put(i, false);
        return false;
    }
}

