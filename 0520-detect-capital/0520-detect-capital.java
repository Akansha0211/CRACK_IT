class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() == 1)return true;
        
        Character ch0 = word.charAt(0);
        Character ch1 = word.charAt(1);
        
        
        // LEETCODE
        if(Character.isUpperCase(ch0)){
            boolean firstChar = Character.isUpperCase(ch1);
            // if second character is uppe then whole string will be of capitals
            // if secomd character is lower than form index = 2 to last will all be lower only
            for(int i = 2; i<word.length() ;i++){
                boolean currChar = Character.isUpperCase(word.charAt(i));
                if(firstChar != currChar)return false;
            }
        }else{
            // if first char i.e index 0 is lower then all should be lower only.
            for(int i = 1; i<word.length(); i++){
                if(Character.isUpperCase(word.charAt(i))){
                    return false;
                }
            }
        }
        return true;
    }
}