class Solution {

    // public int fib(int n) {
    //     if(n==1 || n==0) return n;
    //     return fib(n-1)+fib(n-2);
    // }

    public int fib(int n){
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fibMemo(n, memo);
    }
    static int fibMemo(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != -1) return memo[n];
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }
}