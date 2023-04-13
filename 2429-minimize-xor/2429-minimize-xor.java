class Solution {
    public int minimizeXor(int num1, int num2) {
        int count = Integer.bitCount(num2);
        int ans = 0;
        
        for(int i = 31; i>=0; i--){
            int currBit = (num1 >> i) & 1; // num1 >> i is the current number
            if((currBit == 1) && count >0){
                ans = ans | (1<<i);
                count--;
            }
        }
        // eg num = 1 , num2 = 12
        for(int i = 0; i<32; i++){
            if(count ==0)break;
            int currBit = (ans>>i) & 1;
            if(currBit !=1){
                ans = ans | (1<<i);
                count--;
            }
        }
        
        return ans;
        
        
    }
}