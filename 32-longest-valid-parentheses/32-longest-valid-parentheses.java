class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == ')' && st.size() >1 && s.charAt(st.peek()) == '('){
                st.pop();
                ans = Math.max(ans, i - st.peek());
            }
            else{
                st.push(i);
            }
        }
        return ans;
    }
}