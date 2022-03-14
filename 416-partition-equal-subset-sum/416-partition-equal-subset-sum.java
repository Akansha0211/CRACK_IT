class Solution {
    public boolean canPartition(int[] nums) {
        //totalSum is odd --> then equal partition is not possible
        int totalSum = 0;
        for(int el : nums){
            totalSum+=el;
        }
        if(totalSum %2 != 0)return false;
        Map<String,Boolean> map = new HashMap<>();
        return canPartitionHelper(nums,0, totalSum/2, map);
    }
    public boolean canPartitionHelper(int[] nums, int index, int target,Map<String,Boolean> map ){
        if(target == 0) return true;
        if(index>=nums.length && target != 0)return false;
        String key = Integer.toString(index)+"#" + Integer.toString(target);
        if(map.containsKey(key))return map.get(key);
        boolean inclusion = false;
        if(nums[index]<=target){
            inclusion = canPartitionHelper(nums, index+1, target- nums[index], map);
        }
        boolean exclusion = false;
        if(inclusion == false){
            exclusion = canPartitionHelper(nums, index+1, target, map);
        }
        map.put(key, (inclusion || exclusion));
        return (inclusion || exclusion);
    }
}