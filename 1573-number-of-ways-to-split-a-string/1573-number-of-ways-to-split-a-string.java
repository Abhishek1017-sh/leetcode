class Solution {
    public int numWays(String s) {
        int n = s.length();
        long totalOnes = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') totalOnes++;
        }
        if (totalOnes % 3 != 0) return 0;
        long MOD = 1_000_000_007L;
        if (totalOnes == 0) {
            long gaps = n - 1;
            return (int) ((gaps * (gaps - 1) / 2) % MOD);
        }
        long k = totalOnes / 3;
        long onesSoFar = 0;
        long count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') onesSoFar++;
            if (onesSoFar == k) count1++;
            else if (onesSoFar == 2 * k) count2++;
        }
        return (int) ((count1 * count2) % MOD);
    }
}