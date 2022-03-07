class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(0, s, new ArrayList<>(), ans);
        return ans;
    }
    public static void partitionHelper(int ind, String s, List<String> ds, List<List<String>> ans){
        if(ind == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind; i<s.length(); i++){
            if(isPalindrome(s, ind, i)){
                ds.add(s.substring(ind, i+1));
                partitionHelper(i+1, s, ds, ans);
                ds.remove(ds.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}