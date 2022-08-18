class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        subsetsHelper(0,nums, new ArrayList<Integer>(), ans);
        return ans;
    }
    public void subsetsHelper(int index,int[] nums, List<Integer> ds,  List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        
        // include index
        ds.add(nums[index]);
        subsetsHelper(index+1, nums, ds, ans);
        // not include index
        ds.remove(ds.size()-1);
        subsetsHelper(index+1, nums, ds, ans);
    }
}