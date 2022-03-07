class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsetHelper(0, nums, new ArrayList<>(), ans);
        return ans;
    }
    public static void subsetHelper(int ind, int[] arr, List<Integer> ds, List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
        for(int i = ind; i<arr.length; i++){
            if(i>ind && arr[i] == arr[i-1])continue;
            ds.add(arr[i]);
            subsetHelper(i+1, arr, ds, ans);
            ds.remove(ds.size()-1);
        }
    }
}