class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch== '[' || ch=='{'){
                st.push(ch);
            }
            else if(ch == ')'){
                boolean valid = handleClosing(st, '(');
                if(valid == false)return false;
            }
            else if(ch == '}'){
                boolean valid = handleClosing(st, '{');
                if(valid == false)return false;
            }
            else if(ch == ']'){
                boolean valid = handleClosing(st, '[');
                if(valid == false)return false;
            }
        }
        if(st.isEmpty())return true;
        return false;
    }
    public boolean handleClosing(Stack<Character> st, Character neededAtTop){
        if(st.isEmpty())return false;
        else if(st.peek() != neededAtTop)return false;
        else {
            st.pop();
            return true;
        }
    }
}