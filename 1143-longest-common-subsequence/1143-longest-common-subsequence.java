class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        HashMap<String,Integer> map = new HashMap<>();
        return lcsHelper(0,0, text1, text2, map);
    }
    public int lcsHelper(int i ,int j, String s1, String s2, HashMap<String,Integer> map){
        
        if(i>=s1.length() || j>= s2.length())return 0;
        String key = Integer.toString(i) + "#" + Integer.toString(j);
        if(map.containsKey(key))return map.get(key);
        if(s1.charAt(i) == s2.charAt(j)){
            return 1 + lcsHelper(i+1, j+1, s1, s2, map);
        }
        int choice1 = lcsHelper(i, j+1, s1, s2, map);
        int choice2 = lcsHelper(i+1, j, s1, s2, map);
        map.put(key, Math.max(choice1, choice2));
        return Math.max(choice1, choice2);
    }
}