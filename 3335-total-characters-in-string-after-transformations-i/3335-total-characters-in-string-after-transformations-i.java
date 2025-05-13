class Solution {
    public int lengthAfterTransformations(String s, int t) {
        final int MOD = 1_000_000_007;
        long[] freq = new long[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        for (int step = 0; step < t; step++) {
            long[] next = new long[26];
            for (int i = 0; i < 26; i++) {
                if (i == 25) { // 'z'
                    next[0] = (next[0] + freq[25]) % MOD; // 'a'
                    next[1] = (next[1] + freq[25]) % MOD; // 'b'
                } else {
                    next[i + 1] = (next[i + 1] + freq[i]) % MOD;
                }
            }
            freq = next;
        }
        long total = 0;
        for (int i = 0; i < 26; i++) {
            total = (total + freq[i]) % MOD;
        }
        return (int) total;
    }
}