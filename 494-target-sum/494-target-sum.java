class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String,Integer> map = new HashMap<>();
        return targetHelper(nums, 0, target, map);
    }
    public int targetHelper(int[] nums, int index, int target, Map<String,Integer> map){
        if(index >= nums.length && target == 0)return 1;
        if(index >= nums.length && target != 0) return 0;
        String key = Integer.toString(index) + "#" + Integer.toString(target);
        if(map.containsKey(key))return map.get(key);
        int plus = targetHelper(nums, index+1, target -nums[index], map);
        int neg = targetHelper(nums, index+1, target +nums[index], map);
        map.put(key, plus+neg);
        return plus + neg;
    }
}