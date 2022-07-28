class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisHelper(ans,"", n, n);
        return ans;
    }
    public void  generateParenthesisHelper(List<String> list, String s, int left, int right){
        if(left == 0 && right == 0){
            list.add(s);
        }
        if(left >0){
             generateParenthesisHelper(list, s+"(" , left-1, right);
        }
        if(left<right  && right >0){
             generateParenthesisHelper(list, s+")", left, right-1);
        }
    }
}