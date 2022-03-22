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
        st.push(asteroids[0]);
        for(int i = 1; i<asteroids.length; i++){
            if(asteroids[i] >0){
                st.push(asteroids[i]);
            }else{
                while(!st.isEmpty() && st.peek() >0 && st.peek() < Math.abs(asteroids[i])){
                    st.pop();
                }
                if(st.isEmpty() || st.peek() <0){
                    st.push(asteroids[i]);
                }
                else if(st.peek() == Math.abs(asteroids[i])){
                    st.pop();
                }
                
            }
            
        }
        int[] ans = new int[st.size()];
        for(int i = ans.length-1; i>=0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}










