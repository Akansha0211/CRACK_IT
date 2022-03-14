class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return targetHelper(nums, 0, target);
    }
    public int targetHelper(int[] nums, int index, int target){
        if(index >= nums.length && target == 0)return 1;
        if(index >= nums.length && target != 0) return 0;
        int plus = targetHelper(nums, index+1, target -nums[index]);
        int neg = targetHelper(nums, index+1, target +nums[index]);
        return plus + neg;
    }
}