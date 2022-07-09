class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(st.size() == 0 || st.peek() != s.charAt(i))st.push(s.charAt(i));
            else st.pop();
        }        
        for(char ch : st){
            sb.append(ch);
        }
        return sb.toString();
    }
}