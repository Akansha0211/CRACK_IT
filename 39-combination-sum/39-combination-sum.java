class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        comSumHelper(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
    public static void comSumHelper(int ind, int[]candidates, int target, List<List<Integer>>ans, List<Integer> list){
        if(ind == candidates.length && target == 0){
            ans.add(new ArrayList<>(list));
        }
        if(ind == candidates.length)return;
        
        if(ind >= candidates.length)return;
        
        if(candidates[ind]<=target){
            list.add(candidates[ind]);
            comSumHelper(ind, candidates, target-candidates[ind], ans, list);
            list.remove(list.size()-1);
        }
        comSumHelper(ind+1, candidates, target, ans, list);
    }
}