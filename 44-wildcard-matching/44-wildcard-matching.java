class Solution {
    public boolean isMatch(String s, String p) {
        //int[][] dp = new int[s.length()][p.length()];
       HashMap<String,Boolean> map = new HashMap<>();
        return isMatchHelper(0,0, p, s, map);
    }
    public boolean isMatchHelper(int i , int j, String s1, String s2, HashMap<String,Boolean> map ){
        if(i>=s1.length() && j>=s2.length())return true;
        if(i>=s1.length() && j<s2.length())return false; 
        if(i<s1.length() && j>=s2.length()){
            for(int k = i; k<s1.length(); k++){
                if(s1.charAt(k) != '*')return false;
            }
            return true;
        }
        String key = Integer.toString(i) + "#" + Integer.toString(j);
        if(map.containsKey(key))return map.get(key);
        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?'){
            map.put(key, isMatchHelper(i+1, j+1, s1, s2, map));
            return   isMatchHelper(i+1, j+1, s1, s2, map);
        }
        if(s1.charAt(i) == '*'){
            boolean choice1 = isMatchHelper(i+1, j, s1, s2, map);
            boolean choice2 = isMatchHelper(i, j+1, s1, s2, map);
            map.put(key, (choice1 || choice2));
            return  (choice1 || choice2);
        }
        map.put(key, false);
        return false;
    }
}