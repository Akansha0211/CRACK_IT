class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum+=num;
        }
        if(totalSum %2 != 0)return false;
        int target = totalSum/2;
        int n = nums.length;
        HashMap<String,Boolean> map = new HashMap<>();
        return subsetSumTargetHelper(0, target, nums, map);
    }
    public static boolean subsetSumTargetHelper(int index , int target, int[] nums, HashMap<String,Boolean> map){
        
        if(target == 0)return true;
        if(index>=nums.length && target != 0)return false;
        String key = Integer.toString(index) + "#" + Integer.toString(target);
        if(map.containsKey(key))return map.get(key);
        boolean take = false;
        if(target >= nums[index]){
            take = subsetSumTargetHelper(index+1, target - nums[index], nums, map);
        }
        boolean dontTake = false;
        if(take == false){
            dontTake = subsetSumTargetHelper(index+1, target, nums, map);
        }
        map.put(key, (take || dontTake));
        return (take || dontTake);
    }
    
}