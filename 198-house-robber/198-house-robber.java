class Solution {
    public int rob(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return robHelper(nums, 0, map);
    }
    public int robHelper(int[]nums, int index, HashMap<Integer,Integer> map){
        if(index>=nums.length)return 0;
        if(map.containsKey(index))return map.get(index);
        int rob = nums[index] + robHelper(nums, index+2, map);
        int dontRob = robHelper(nums, index+1, map);
        map.put(index, Math.max(rob, dontRob));
        return map.get(index);
    }
}