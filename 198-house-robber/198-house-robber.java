class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        
        int prev = nums[0]; // 0 index for i-1 (when i = 1)
        int prev2 = 0; // -1 index for i-2 
        int curr_i = 0;
        
        for(int i = 1; i<nums.length; i++){
            
            int take = nums[i];
            if(i>1)take += prev2;
            
            int notTake = prev;
            
            curr_i = Math.max(take, notTake);
            
            prev2 = prev;
            prev = curr_i;
            
        }
        return prev;
        
    }
}