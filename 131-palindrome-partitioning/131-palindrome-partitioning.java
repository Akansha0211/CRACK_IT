class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<String>(), ans);
        return ans;
    }
    public void partitionHelper(String s,int index, List<String> ds, List<List<String>> ans){
        if(index == s.length()){
            ans.add(new ArrayList<String>(ds));
            return;
        }
        for(int i = index; i<s.length(); i++){
            if(isValid(s, index, i)){
                ds.add(s.substring(index, i+1));
                partitionHelper(s, i+1, ds, ans);
                ds.remove(ds.size()-1);
                
            }
        }
    }
    public boolean isValid(String s, int start, int end){
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