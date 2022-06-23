class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int maxLen = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int currNum = num;
                int currLen = 1;
                
                while(set.contains(currNum+1)){
                    currNum = currNum+1;
                    currLen+=1;
                }
                
                maxLen = Math.max(maxLen,currLen);
            }
            
            
        }
        return maxLen;
    }
}