class Solution {
    public int firstUniqChar(String s) {
        int idx = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            
            if(map.getOrDefault(s.charAt(idx),0)>1){
                idx++;
                
                while(idx<s.length() && map.getOrDefault(s.charAt(idx),0)>1){
                    idx++;
                }
                if(idx == s.length())return -1;
            }
        }
        return idx;
    }
}