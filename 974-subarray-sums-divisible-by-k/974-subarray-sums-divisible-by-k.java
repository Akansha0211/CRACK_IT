class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int prefixSum = 0;
        int prefixmodK = 0;
        for(int i = 0; i<nums.length; i++){
            prefixSum += nums[i];
            prefixmodK = prefixSum % k;
            if(prefixmodK <0){
                prefixmodK += k;
            }
            if(map.containsKey(prefixmodK)){
                count+=map.get(prefixmodK);
            }
            map.put(prefixmodK, map.getOrDefault(prefixmodK, 0)+1);
        }
        return count;
    }
}