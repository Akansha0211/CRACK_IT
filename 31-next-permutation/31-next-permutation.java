class Solution {
    public void nextPermutation(int[] nums) {
        // find dip
        int i = nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])i--;
        //if you found dip
        if(i>=0){
            // find just greater element
            int j = nums.length-1;
            while(nums[j]<=nums[i])j--;
            // swap both the indexes (dip , next greater)
            swap(i, j,nums);
        }
        // reverse
        reverse(nums, i+1, nums.length-1);
    }
    public void swap(int i , int j , int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void reverse(int[] nums, int i, int j){
        while(i<j)swap(i++, j--, nums);
    }
}