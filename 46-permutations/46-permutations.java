class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[nums.length];
        backtrack(new ArrayList<Integer>(), nums, ans, vis);
        return ans;
    }
    
    public void backtrack(List<Integer> list, int[] nums, List<List<Integer>> ans, boolean[] vis){
        if(list.size() == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length ; i++){
            if(vis[i] == true)continue;
            list.add(nums[i]);
            vis[i] = true;
            backtrack(list, nums, ans, vis);
            list.remove(list.size() - 1);
            vis[i] = false;
        }
    }
}