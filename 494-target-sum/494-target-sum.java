class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findWaysHelper(0, target, nums);
    }
    public int findWaysHelper(int index, int target, int[]nums){
        if(index>=nums.length && target == 0)return 1;
        if(index >= nums.length && target != 0)return 0;
        int plus = findWaysHelper(index+1, target-nums[index], nums);
        int neg  =  findWaysHelper(index+1, target + nums[index], nums); 
        return plus + neg;
    }
}