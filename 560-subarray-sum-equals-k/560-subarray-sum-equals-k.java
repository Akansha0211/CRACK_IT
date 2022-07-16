class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;
        int cnt = 0;
        for(int el : nums){
            prefixSum+=el;
            
            if(map.containsKey(prefixSum -k))cnt+= map.get(prefixSum-k);
            
            map.put(prefixSum, map.getOrDefault(prefixSum,0)+1);
            
        }
        return cnt;
    }
}