class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        
        int maxChar = 0;
        int n = s.length();
        while(right< n){
            char ch = s.charAt(right);
            
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxChar = Math.max(maxChar, map.get(ch)); // compare with count of each char
            
            int numOfChars = (right - left +1) - maxChar; // number of char leaves to be replaced in that window
            if(numOfChars >k){
                char chRem = s.charAt(left); 
                left++;
                map.put(chRem, map.get(chRem)-1);
            }
            ans = Math.max(ans, right - left +1);
            
            right++;
        }
        return ans;
    }
}