class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // collison sirf ek case main hoga i.e
        // ith banda -ve and stack ke top par +ve
        /*
        four cases
        
        surviving  ith bnda
             +         +   (no collison)
             -         +    (no collision)
             +         -     (collides)
             -         -     (no collision)
        */
        
        
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i< asteroids.length){
            if(st.isEmpty() || asteroids[i] >0 || st.peek() <0){
                st.push(asteroids[i]);
                i++;
            }else if(Math.abs(asteroids[i]) < st.peek()){
                i++;
            }else if(Math.abs(asteroids[i]) > st.peek()){
                st.pop();
            }else if(Math.abs(asteroids[i]) == st.peek()){
                st.pop();
                i++;
            }
        }
        int[] ans = new int[st.size()];
        for(int j = ans.length-1; j>=0; j--){
            ans[j] = st.pop();
        }
        return ans;
    }
}










