class Solution {
    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();
        int[] dict = new int[26];
        for(int i = 0; i<words[0].length(); i++){
            dict[words[0].charAt(i)-'a']++;
        }
        for(int i = 1; i<words.length; i++){
            int[] curr = new int[26];
            for(int j = 0; j<words[i].length(); j++){
                curr[words[i].charAt(j)-'a']++;
            }
            for(int j = 0; j<26; j++){
                if(curr[j]< dict[j])dict[j] = curr[j];
            }
        }
        for(int i = 0; i<26; i++){
            for(int j = 0; j<dict[i]; j++){
                if(dict[i] >= 1){
                    ans.add(Character.toString((char)('a' + i)));
                }
            }
        }
        return ans;
    }
}