class Solution {
    public int fib(int n) {
        int ans= fibHelper(n);
        return ans;
    }
    public int fibHelper(int n){
        if(n == 0|| n==1)return n;
        return fibHelper(n-1)+fibHelper(n-2);
    }
}