class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                int start = num;
                int end = num;
                
                if(map.containsKey(start-1)){
                    start = num - map.get(start-1);
                }
                if(map.containsKey(end +1)){
                    end = num + map.get(end +1);
                }
                int currLen = (end - start)+1;
                map.put(start, currLen);
                map.put(end, currLen);
                
                if(start != num && end != num){
                    map.put(num, 1);
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}