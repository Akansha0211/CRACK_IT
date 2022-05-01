class Solution {
//     public boolean backspaceCompare(String s, String t) {
//         Stack<Character> st_s = new Stack<>();
//         Stack<Character> st_t = new Stack<>();
        
//         for(int i = 0; i<s.length(); i++){
//             if(s.charAt(i) == '#' && !st_s.isEmpty())st_s.pop();
//             else{
//                 st_s.push(s.charAt(i));
//             }
//         }
//         for(int i = 0; i<t.length(); i++){
//             if(t.charAt(i) == '#' && !st_t.isEmpty())st_t.pop();
//             else{
//                 st_t.push(t.charAt(i));
//             }
//         }
        
//         System.out.println(String.valueOf(st_s));
//         System.out.println(String.valueOf(st_t));
//         return (String.valueOf(st_s).equals(String.valueOf(st_t)));
//     }
    public boolean backspaceCompare(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}