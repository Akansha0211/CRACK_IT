class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean vis[] = new boolean[nums.length];
        Arrays.sort(nums);
        permuteHelper(nums, ans, new ArrayList<Integer>(),vis);
        return ans;
    }
    public void permuteHelper(int[] arr,List<List<Integer>> ans,ArrayList<Integer> ds, boolean[] vis){
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0; i<arr.length; i++){
            if(vis[i] || i>0 && arr[i] == arr[i-1] && !vis[i-1])continue;
            ds.add(arr[i]);
            vis[i] = true;
            permuteHelper(arr, ans,ds, vis);
            ds.remove(ds.size()-1);
            vis[i] = false;
        }
    }
}