class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer>  map = new HashMap<>();
        int left = 0;
        int right = 0;
        int len = 0;
        int n = s.length();
        while(right < n){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right))+1);
            }
            len = Math.max(len, right - left +1);
            map.put(s.charAt(right), right);
            right++;
        }
        return len;
    }
}