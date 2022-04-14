class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currCount = 0;
        int overallCount = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0)currCount = 0;
            else{
                currCount+=1;
                overallCount = Math.max(overallCount, currCount);
            }
        }
        return overallCount;
    }
}