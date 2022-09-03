class Solution {
    public int rob(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return robHelper(0, nums, map);
        
    }
    public int robHelper(int index, int[]nums, HashMap<Integer,Integer> map){
        if(index>=nums.length)return 0;
        if(map.containsKey(index))return map.get(index);
        int rob = nums[index] +  robHelper(index+2, nums, map);
        int dontRob = robHelper(index+1, nums, map);
        map.put(index, Math.max(rob,dontRob));
        return  Math.max(rob, dontRob);
    }
}