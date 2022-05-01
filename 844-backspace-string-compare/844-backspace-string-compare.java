class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> st_s = new Stack<>();
        Stack<Character> st_t = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            // if(s.charAt(i) == '#' && !st_s.isEmpty()){
            //     st_s.pop();
            // }else{
            //     st_s.push(s.charAt(i));
            // }
            if(s.charAt(i) != '#'){
                st_s.push(s.charAt(i));
            }
            else if(!st_s.isEmpty()){
                st_s.pop();
            }
        }
        
        for(int i = 0; i<t.length(); i++){
            if(t.charAt(i) != '#'){
                st_t.push(t.charAt(i));
            }
            else if(!st_t.isEmpty()){
                st_t.pop();
            }
        }
        
        return String.valueOf(st_s).equals(String.valueOf(st_t));
    }
}