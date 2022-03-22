class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 1; i<temperatures.length; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                ans[st.peek()] = i - st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.pop()] = 0;
        }
        return ans;
    }
}