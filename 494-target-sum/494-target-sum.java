class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<String,Integer> map = new HashMap<>();
        return targetSumHelper(0, target, nums, map);
    }
    public int targetSumHelper(int index, int target, int[] nums, HashMap<String, Integer> map){
        if(index >= nums.length && target == 0)return 1;
        if(index >= nums.length && target != 0)return 0;
        String key = index + "#" + target;
        if(map.containsKey(key))return map.get(key);
        int plus = targetSumHelper(index+1, target - nums[index], nums, map);
        int neg  = targetSumHelper(index+1, target + nums[index], nums, map);
        map.put(key, plus + neg);
        return (plus + neg);
    }
}