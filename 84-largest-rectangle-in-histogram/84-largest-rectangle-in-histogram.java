class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i = 0; i<= heights.length; i++){
            int height = (i == heights.length) ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()] > height){
                int index = st.pop();
                int nsr = i;
                int nsl = st.isEmpty() ? -1 : st.peek();
                
                max = Math.max(max, heights[index] * (nsr - nsl-1));
            }
            st.push(i);
        }
        return max;
    }
}
