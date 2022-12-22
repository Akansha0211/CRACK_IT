class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        HashMap<Integer,Boolean> checked = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], true);
        }
        int longestChain = 0;
        
        for(int i = 0; i<nums.length; i++){
            if(!checked.containsKey(nums[i]) && !map.containsKey(nums[i]-1)){
                int currentChain = 0;
                int start = nums[i];
                while(map.containsKey(start)){
                    currentChain++;
                    checked.put(start, true);
                    start++;
                }
                longestChain = Math.max(longestChain, currentChain);
            }
        }
        return longestChain;
    }
}