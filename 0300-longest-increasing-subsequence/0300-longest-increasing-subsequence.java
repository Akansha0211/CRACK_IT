class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        int[] next = new int[n+1];
        int[] curr = new int[n+1];
        for(int index = n-1; index>=0 ; index--){
            for(int prevIndex = index-1; prevIndex >=-1; prevIndex--){
                
                int len = 0 + next[prevIndex+1];
                if(prevIndex == -1 || nums[prevIndex] < nums[index]){
                    len = Math.max(len, 1 + next[index+1]);
                }
                curr[prevIndex+1] = len;
            }
            next = curr;
        }
        return next[-1+1];
    }
   
}