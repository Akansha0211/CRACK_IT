class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+= nums[i];
        }
        if(sum %2 != 0)return false;
        HashMap<String, Boolean> map = new HashMap<>();
        return canPartitionHelper(nums,0, sum/2, map);
        
    }
    public boolean canPartitionHelper(int[] nums, int index, int target, HashMap<String, Boolean> map){
        
        if(target == 0)return true;
        if(index >= nums.length && target != 0)return false;
        
        String key = index + "#" + target;
        if(map.containsKey(key))return map.get(key);
        
        boolean choose = false;
        if(nums[index] <= target){
            choose = canPartitionHelper(nums, index+1 , target - nums[index], map);
        }
        boolean dont = false;
        if(choose == false){
            dont = canPartitionHelper(nums, index + 1 , target, map);
        }
        map.put(key, (choose || dont));
        
        return (choose || dont);
    }
}