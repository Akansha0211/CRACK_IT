class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        return Math.max(robHelper(nums, 0,nums.length-1, map1), robHelper(nums, 1,nums.length, map2));
    }
    public int robHelper(int[]nums, int index,int length,Map<Integer,Integer> map){
        if(index>=length)return 0;
        if(map.containsKey(index))return map.get(index);
        int rob = nums[index] + robHelper(nums, index+2,length, map);
        int dontRob = robHelper(nums, index+1,length, map);
        map.put(index, Math.max(rob, dontRob));
        return map.get(index);
    }
}