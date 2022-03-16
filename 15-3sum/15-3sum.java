class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            int target = 0 - (nums[i]);
            // int rest = 0 - target;
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[j] + nums[k] > target){
                    k--;
                }
                else if(nums[j] + nums[k] < target){
                    j++;
                }
                else{
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(set);
    }
}