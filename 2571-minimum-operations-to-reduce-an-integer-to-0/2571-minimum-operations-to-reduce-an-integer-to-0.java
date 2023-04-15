class Solution {
    public int minOperations(int n) {
        //int msb = log(n);
        int adding_operations = 0;
        for(int i = 0; i<20; i++){
            if(Integer.bitCount(n+(1<<i)) < Integer.bitCount(n)){
                adding_operations++;
                n+=(1<<i);
            }
        }
        int sub_opn = Integer.bitCount(n);
        return adding_operations + sub_opn;
    }
}