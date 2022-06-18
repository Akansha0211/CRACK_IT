class Solution {
    public String reverseWords(String s) {
        
        String ans = "";
        int i = s.length()-1;
        int j = 0;
        while(i>=0){
            while(i>=0 && s.charAt(i) == ' ')i--; // dealing with ending zeroes
            j = i;
            
            if(i<0)break; // dealing with starting zeroes
            while(i>=0 && s.charAt(i) != ' ')i--;
            if(ans.length() == 0){
                ans = ans.concat(s.substring(i+1, j+1));
            }else{
                ans = ans.concat(" " + s.substring(i+1, j+1));
            }
        }
        return ans;
    }
}