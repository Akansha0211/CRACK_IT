class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int max_len = 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                int start = num;
                int end = num;
                if(map.containsKey(num-1)){
                    start = start - map.get(num-1);
                }
                if(map.containsKey(num+1)){
                    end = end + map.get(num+1);
                }
                max_len = Math.max(max_len, (end-start)+1);
                map.put(start, (end-start)+1);
                map.put(end, (end-start)+1);
                if(start != num && end != num)map.put(num, 1);
            }
        }
        return max_len;
    }
}