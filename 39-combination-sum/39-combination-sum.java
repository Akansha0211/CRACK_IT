class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationHelper(0, target, candidates, new ArrayList<Integer>(), ans);
        return ans;
    }
    public void combinationHelper(int index, int target, int[]candidates, List<Integer> ds, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(index>=candidates.length)return;
        
        
        //pick
        if(candidates[index]<=target){
            ds.add(candidates[index]);
            combinationHelper(index, target - candidates[index],candidates, ds, ans);
            ds.remove(ds.size()-1);
        }
        // do not pick
        combinationHelper(index+1, target, candidates, ds, ans);
    }
}