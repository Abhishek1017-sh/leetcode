class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        int size = 1 << n;
        boolean[] valid = new boolean[size];
        for (int mask = 0; mask < size; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += tasks[i];
                }
            }
            valid[mask] = sum <= sessionTime;
        }
        int[] dp = new int[size];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 1; mask < size; mask++) {
            for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
                if (valid[sub]) {
                    dp[mask] = Math.min(dp[mask], dp[mask ^ sub] + 1);
                }
            }
        }
        return dp[size - 1];
    }
}