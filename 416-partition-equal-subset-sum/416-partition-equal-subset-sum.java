class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0 ; i<nums.length ; i++){
            sum+= nums[i];
        }
        if(sum %2 != 0)return false;
        HashMap<String,Boolean> map = new HashMap<>();
        return subsetSumTargetHelper(0, sum/2, nums, map);
    }
    public boolean subsetSumTargetHelper(int ind, int target, int[] nums, HashMap<String,Boolean> map){
        
        if(target == 0)return true;
        if(ind >= nums.length && target != 0)return false;
        
        String key = ind + "#" + target;
        if(map.containsKey(key))return map.get(key);
        
        boolean take = false;
        if(target >= nums[ind]){
            take = subsetSumTargetHelper(ind+1, target - nums[ind] , nums, map);
        } 
        boolean notTake = false;
        if(take == false){
            notTake = subsetSumTargetHelper(ind+1, target, nums, map);
        }
                 
        map.put(key, notTake | take);
        return notTake | take;
    }
    
}