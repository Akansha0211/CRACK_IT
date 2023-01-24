class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0; 
        int j = nums.length-1;
        int k = nums.length-1;
        int[] ans = new int[nums.length];
        while(i<=j){
            int val1 = nums[i]* nums[i];
            int val2 = nums[j] * nums[j];
            if(val1> val2){
                ans[k] = val1;
                i++;
            }else{
                ans[k] = val2;
                j--;
            }
            k--;
        }
        return ans;
    }
}