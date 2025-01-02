class Solution {
    private boolean isVowelStartEnd(String word) {
        String vowels = "aeiou";
        return vowels.indexOf(word.charAt(0)) != -1 && vowels.indexOf(word.charAt(word.length() - 1)) != -1;
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n];
        String vowels = "aeiou";
        prefix[0] = (isVowelStartEnd(words[0])) ? 1 : 0;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (isVowelStartEnd(words[i]) ? 1 : 0);
        }
        int m = queries.length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            result[i] = (li > 0) ? prefix[ri] - prefix[li - 1] : prefix[ri];
        }
        return result;
    }
}