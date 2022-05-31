class Solution {
    public String removeKdigits(String num, int k) {
        
        if(k == num.length())return "0";
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<num.length(); i++){
            while(!st.isEmpty() && k>0 && st.peek() > num.charAt(i)){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(!st.isEmpty() && k>0){
            st.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        
        while(sb.length() >1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
        
        
    }
}