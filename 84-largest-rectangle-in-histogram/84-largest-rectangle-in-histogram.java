class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i = 0; i<=heights.length; i++){
            int height = i == heights.length ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()] > height){
                int nsr = i;
                int idx = st.pop();
                int nsl = st.isEmpty() ? -1 : st.peek();
                
                int width = nsr - nsl -1;
                max = Math.max(max, heights[idx]*width);
            }
            st.push(i);
        }
        return max;
    }
}