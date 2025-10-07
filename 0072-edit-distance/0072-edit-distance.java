class Solution {
    public int minDistance(String word1, String word2) {
         return solve(word1, word2, word1.length(), word2.length());
    }

    static int solve(String w1, String w2, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;

        if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
            return solve(w1, w2, m - 1, n - 1);
        } else {
            int insert = 1 + solve(w1, w2, m, n - 1);
            int delete = 1 + solve(w1, w2, m - 1, n);
            int replace = 1 + solve(w1, w2, m - 1, n - 1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }
}