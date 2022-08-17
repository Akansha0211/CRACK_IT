class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        permutationHelper(nums, new boolean[nums.length], new ArrayList<Integer>(), ans);
        return ans;
    }
    public void permutationHelper(int[] nums, boolean[] vis, List<Integer> ds, List<List<Integer>> ans){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i = 0; i<nums.length; i++){
            if(vis[i] == true)continue;
            ds.add(nums[i]);
            vis[i] = true;
            permutationHelper(nums, vis, ds, ans);
            ds.remove(ds.size()-1);
            vis[i] = false;
        }
    }
}