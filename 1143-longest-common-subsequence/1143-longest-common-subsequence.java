class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        HashMap<String, Integer> map = new HashMap<>();
        return lcsHelper(text1, text2, 0,0, map);
    }
    public int lcsHelper(String s1, String s2, int i , int j, HashMap<String,Integer> map){
        if(i>=s1.length() || j>=s2.length())return 0;
        String key = i + "#" + j;
        if(map.containsKey(key))return map.get(key);
        if(s1.charAt(i) == s2.charAt(j)){
            map.put(key, 1+ lcsHelper(s1, s2, i+1, j+1, map));
            return map.get(key);
        }
        else{
            int choice1 = lcsHelper(s1, s2, i, j+1, map);
            int choice2 = lcsHelper(s1, s2, i+1, j, map);
            map.put(key, Math.max(choice1, choice2));
            // return Math.max(choice1, choice2);
            return map.get(key);
            
        }
    }
}