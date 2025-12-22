class Solution {
    public String smallestPalindrome(String s, int k) {
        int LIMIT = k;
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        char mid = 0;
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }
        int halfLen = s.length() / 2;
        int[] half = new int[26];
        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }
        long total = countWays(half, LIMIT);
        if (total < k) return "";
        StringBuilder left = new StringBuilder();
        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;
                half[c]--;
                long cnt = countWays(half, LIMIT);
                if (cnt >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= cnt;
                    half[c]++;
                }
            }
        }
        String right = new StringBuilder(left).reverse().toString();
        if (odd == 1) {
            return left.toString() + mid + right;
        }
        return left.toString() + right;
    }
    long countWays(int[] count, int LIMIT) {
        long res = 1;
        int used = 0;
        for (int c : count) {
            for (int i = 1; i <= c; i++) {
                res = res * (used + i) / i;
                if (res > LIMIT) return LIMIT;
            }
            used += c;
        }
        return res;
    }
}