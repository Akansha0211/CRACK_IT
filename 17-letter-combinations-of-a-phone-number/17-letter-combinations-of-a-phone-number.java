class Solution {
    String[] keys = {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;        
        combination("", digits, 0, ans);
        return ans;
    }
    public void combination(String prefix, String digits, int ind, List<String> ans){
        if(ind>=digits.length()){
            ans.add(prefix);
            return;
        }
        String letters = keys[(digits.charAt(ind)-'0')];
        for(int i = 0; i<letters.length(); i++){
            combination(prefix + letters.charAt(i), digits, ind+1, ans);
        }
    }
}