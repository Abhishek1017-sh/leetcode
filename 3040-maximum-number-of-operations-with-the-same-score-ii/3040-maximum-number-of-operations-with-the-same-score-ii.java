class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int s1 = nums[0] + nums[1];
        int s2 = nums[0] + nums[n - 1];
        int s3 = nums[n - 2] + nums[n - 1];
        ans = Math.max(ans, solve(nums, s1));
        ans = Math.max(ans, solve(nums, s2));
        ans = Math.max(ans, solve(nums, s3));
        return ans;
    }
    private int solve(int[] nums, int score) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        return dfs(nums, 0, n - 1, score, dp);
    }
    private int dfs(int[] nums, int lo, int hi, int score, int[][] dp) {
        if (hi <= lo) return 0;
        if (dp[lo][hi] != -1) return dp[lo][hi];
        int max = 0;
        if (nums[lo] + nums[lo + 1] == score)
            max = Math.max(max, 1 + dfs(nums, lo + 2, hi, score, dp));
        if (nums[lo] + nums[hi] == score)
            max = Math.max(max, 1 + dfs(nums, lo + 1, hi - 1, score, dp));
        if (nums[hi - 1] + nums[hi] == score)
            max = Math.max(max, 1 + dfs(nums, lo, hi - 2, score, dp));
        return dp[lo][hi] = max;
    }
}
