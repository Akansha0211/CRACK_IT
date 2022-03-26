class Solution {
    public int minDistance(String word1, String word2) {
        HashMap<String,Integer> map = new HashMap<>();
        return minDistanceHelper(word1, word2, 0,0, map);
    }
    public int minDistanceHelper(String word1, String word2, int i , int j, HashMap<String,Integer> map){
        if(word1.length() ==0)return word2.length();
        if(word2.length() ==0)return word1.length();
        
        if(i >= word1.length())return word2.length() - j;
        if(j >= word2.length())return word1.length() -i;
        
        String key = i + "#" + j;
        if(map.containsKey(key))return map.get(key);
        if(word1.charAt(i) == word2.charAt(j)){
            map.put(key, minDistanceHelper(word1, word2, i+1, j+1, map));
            return minDistanceHelper(word1, word2, i+1, j+1, map);
        }
        int insert = minDistanceHelper(word1, word2, i, j+1, map);
        int delete = minDistanceHelper(word1, word2, i+1, j, map);
        int replace = minDistanceHelper(word1, word2, i+1, j+1, map);
        
        map.put(key, 1 + Math.min(replace, Math.min(insert, delete)));
        
        return 1 + Math.min(replace, Math.min(insert, delete));
    }
}