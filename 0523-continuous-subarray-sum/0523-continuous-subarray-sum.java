class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefixSum = 0;
        int prefixSumModk = 0;
        for(int i = 0; i<nums.length; i++){
            prefixSum+=nums[i];
            prefixSumModk = prefixSum % k;
            if(prefixSumModk == 0 && i+1 >=2)return true;
            if(map.containsKey(prefixSumModk) ){
                if((i - map.get(prefixSumModk)) >=2)return true;
            }
            else map.put(prefixSumModk, i);
        }
        return false;
    }
}