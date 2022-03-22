class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[] arr = new int[matrix[0].length];
        int overallMax = Integer.MIN_VALUE;
        for(int i = 0; i<matrix.length; i++){
            for(int j =0; j<matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    arr[j]+=1;
                }else{
                    arr[j] = 0;
                }
            }
            int ma = largestAreaHistogram(arr);
            overallMax =Math.max(overallMax, ma);
        }
        return overallMax;
    }
    
    public int largestAreaHistogram(int[] arr){
        Stack<Integer> st = new Stack<>();
        int max = 0;
        for(int i = 0; i<=arr.length; i++){
            int height = i == arr.length ? 0 : arr[i];
            while(!st.isEmpty() && arr[st.peek()] > height){
                int nsr = i;
                int idx = st.pop();
                int nsl = st.isEmpty()? -1 : st.peek();
                
                int width = nsr - nsl -1;
                max = Math.max(max, arr[idx]*width);
            } 
            st.push(i);
        }
        return max;
               
    }
}