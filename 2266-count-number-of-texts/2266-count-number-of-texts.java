class Solution {
    public int countTexts(String pressedKeys) {
        int mod = 1_000_000_007;
        int n = pressedKeys.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char ch = pressedKeys.charAt(i - 1);
            int limit = (ch == '7' || ch == '9') ? 4 : 3;
            for (int len = 1; len <= limit && i - len >= 0; len++) {
                if (pressedKeys.charAt(i - len) != ch) break;
                dp[i] = (dp[i] + dp[i - len]) % mod;
            }
        }
        return (int) dp[n];
    }
}
