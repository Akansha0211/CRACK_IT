class Solution {
    public int firstUniqChar(String s) {
        for(int i = 0; i<s.length(); i++){
            for(int j = 0; j<s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && i!=j){
                    break;
                }
                if(j == s.length()-1)return i;
            }
        }
        return -1;
    }
}