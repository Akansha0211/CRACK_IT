class Solution {
    public int missingNumber(int[] nums) {
        // int n = nums.length;
        // int sum = 0;
        // for(int i = 0; i<nums.length; i++){
        //     sum+=nums[i];
        // }
        // return (n*(n+1))/2 - sum;
        
        int sum = nums.length;
        for(int i = 0; i<nums.length; i++){
            sum+=i - nums[i];
        }
        return sum;
    }
}