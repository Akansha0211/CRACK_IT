class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        int j = 0;
        while(i<pushed.length){
            if(st.isEmpty() || st.peek() != popped[j]){
                st.push(pushed[i]);
                i++;
            }
            while(!st.isEmpty() && st.peek() == popped[j]){
                st.pop();
                j++;
            }
        }
        return st.isEmpty();
    }
}