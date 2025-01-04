class Solution {
    public int countPalindromicSubsequence(String s) {
        Set<String> map = new HashSet<>();
        int n = s.length();
        boolean[] before = new boolean[26];
        int[] after = new int[26];
        for (char c : s.toCharArray()) {
            after[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            char middle = s.charAt(i);
            int middleIndex = middle - 'a';
            after[middleIndex]--;
            for (int j = 0; j < 26; j++) {
                if (before[j] && after[j] > 0) {
                    String palindrome = ""+(char)(j+'a')+middle+(char) (j+'a');
                    map.add(palindrome);
                }
            }
            before[middleIndex] = true;
        }
        return map.size();
    }
}