class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combineHelper(n, 1, k, ans, new ArrayList<>());
        return ans;
    }
    public static void combineHelper(int n , int index, int k, List<List<Integer>> ans, List<Integer> ds){
        if(ds.size() == k){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        for(int i = index; i<=n; i++){
            ds.add(i);
            combineHelper(n, i+1, k, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
}