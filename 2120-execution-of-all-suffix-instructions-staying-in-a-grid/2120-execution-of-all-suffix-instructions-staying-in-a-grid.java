class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ans = new int[s.length()];
        int row = startPos[0];
        int col = startPos[1];
        int cnt = 0;
        for(int i =  0; i<s.length(); i++){
            cnt = 0;
            row = startPos[0];
            col = startPos[1];
            for(int j = i; j<s.length(); j++){
                if(s.charAt(j) == 'R'){
                    col++;
                }
                else if(s.charAt(j)=='L'){
                    col--;
                }
                else if(s.charAt(j)=='D'){
                    row++;
                }
                else if(s.charAt(j)=='U'){
                    row--;
                }
                if(row<0 || col<0 || row>=n || col>=n){
                    break;
                }else{
                    cnt++;
                }
                
            }
            ans[i] = cnt;
            
        }
        return ans;
    }
}