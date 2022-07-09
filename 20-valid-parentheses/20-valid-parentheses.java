class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        HashMap<Character,Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch))st.push(ch);
            else{
                if(st.size() == 0)return false;
                else if(map.get(st.peek())==ch)st.pop();
                else return false;
            }
        }
        if(st.size() == 0)return true;
        return false;
    }
}