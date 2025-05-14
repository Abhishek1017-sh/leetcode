class Solution {
    static int MOD=1000000007;
    public int lengthAfterTransformations(String s, int t, List<Integer> nums) {
        long[] freq = new long[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (int step = 0; step < t; step++) {
            long[] next = new long[26];
            for (int i = 0; i < 26; i++) {
                long count = freq[i];
                int shift = nums.get(i);
                for (int j = 1; j <= shift; j++) {
                    int newChar = (i + j) % 26;
                    next[newChar] = (next[newChar] + count) % MOD;
                }
            }
            freq = next;
        }
        long total = 0;
        for (long f : freq) total = (total + f) % MOD;
        return (int) total;
    }
}