class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        int[] house = new int[max+1];
        for(int i = 0; i<nums.length; i++){
            int val = nums[i];
            house[val] +=val;
        }
        Map<Integer,Integer> map = new HashMap<>();
        return robHelper(0, house, map);
    }
    public int robHelper(int index , int[] house, Map<Integer,Integer> map){
        if(index>=house.length)return 0;
        if(map.containsKey(index))return map.get(index);
        int rob = house[index] + robHelper(index+2, house, map);
        int dontRob = robHelper(index+1, house, map);
        map.put(index, Math.max(rob, dontRob));
        return Math.max(rob, dontRob);
    }
}