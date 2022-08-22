class Solution {
    public int fib(int n) {
        return fibHelper(n);
    }
    public int fibHelper(int n){
        if(n== 0)return 0;
        if(n==1)return 1;
        int choice1 = fibHelper(n-1);
        int choice2 = fibHelper(n-2);
        return choice1 + choice2;
    }
}