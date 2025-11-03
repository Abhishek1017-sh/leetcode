class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int dp[]=new int[n+1];
        for(int i=1;i<=m;i++){
            int prevdig=0;
            for(int j=1;j<=n;j++){
                int t=dp[j];
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[j]=1+prevdig;
                }
                else{
                    dp[j]=Math.max(dp[j],dp[j-1]);
                }
                prevdig=t;
            }
            
        }
        return (word1.length()-dp[n])+(word2.length()-dp[n]);
    }
}