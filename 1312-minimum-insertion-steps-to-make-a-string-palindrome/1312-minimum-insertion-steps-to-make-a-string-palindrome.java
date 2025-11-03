class Solution {
    public int minInsertions(String s) {
        int n=s.length();
        int dp[]=new int[n+1];
        for(int i=1;i<=n;i++){
            int prevdig=0;
            for(int j=1;j<=n;j++){
                int t=dp[j];
                if(s.charAt(i-1)==s.charAt(n-j)){
                    dp[j]=1+prevdig;
                }
                else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                prevdig=t;
            }
        }
        return s.length()-dp[n];
    }
}