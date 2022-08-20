class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(0,nums, new ArrayList<>(), ans);
        return ans;      
    }
    public void subsetsHelper(int index, int[] nums, ArrayList<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = index; i<nums.length; i++){
            if(i!=index && nums[i] == nums[i-1])continue;
            ds.add(nums[i]);
            subsetsHelper(i+1, nums, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}