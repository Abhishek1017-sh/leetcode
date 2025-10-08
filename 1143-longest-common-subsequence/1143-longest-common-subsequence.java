class Solution {
    public int helper(String text1, String text2, int[][] dp) {
        if (text1.isEmpty() || text2.isEmpty())
            return 0;
        if (dp[text1.length() - 1][text2.length() - 1] != -1)
            return dp[text1.length() - 1][text2.length()-1];

        char ch1 = text1.charAt(0);
        char ch2 = text2.charAt(0);
        if (ch1 == ch2) {
            return dp[text1.length() - 1][text2.length()-1] =1+ helper(text1.substring(1), text2.substring(1), dp);
        } else {
            int left = helper(text1, text2.substring(1), dp);
            int right = helper(text1.substring(1), text2, dp);
            return dp[text1.length() - 1][text2.length()-1] = Math.max(left, right);
        }

    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(text1, text2,dp);
    }
}