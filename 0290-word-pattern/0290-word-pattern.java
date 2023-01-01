class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character,String> map = new HashMap<>();
        HashMap<String,Character> map2 = new HashMap<>();
        
        String[] arr = new String[pattern.length()];
        arr = s.split(" ");
        if(pattern.length() != arr.length)return false;
        for(int i = 0; i<pattern.length(); i++){            
            if(!map.containsKey(pattern.charAt(i)) && !map2.containsKey(arr[i])){
                map.put(pattern.charAt(i), arr[i]);
                map2.put(arr[i], pattern.charAt(i));
            }
            else if(map.containsKey(pattern.charAt(i)) && ! map2.containsKey(arr[i])){
                return false;
            }
            else if(!map.containsKey(pattern.charAt(i)) && map2.containsKey(arr[i])){
                return false;
            }
            else{
                if( !(map.get(pattern.charAt(i)).equals(arr[i])) ){
                    return false;
                }
            }
        }
        return true;
    }
}