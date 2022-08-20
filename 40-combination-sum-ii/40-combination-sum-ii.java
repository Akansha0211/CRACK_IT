class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationHelper(0, target, candidates, new ArrayList<Integer>(), ans);
        return ans;
    }
    public void combinationHelper(int index, int target, int[] candidates, ArrayList<Integer> ds,
                                List<List<Integer>> ans){
        // BC
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = index; i<candidates.length; i++){
            
            if(i!=index && candidates[i] == candidates[i-1])continue;
            
            if(candidates[i] > target)break;
            
            ds.add(candidates[i]);
            combinationHelper(i+1, target-candidates[i],candidates, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}