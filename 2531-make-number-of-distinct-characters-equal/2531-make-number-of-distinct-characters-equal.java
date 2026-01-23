class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] m1 = new int[26];
        int[] m2 = new int[26];
        int c1 = 0;
        int c2 = 0;
        for (char c : word1.toCharArray()){
            if (m1[c-'a']++ == 0) c1++;
        }
        for (char c : word2.toCharArray()){
            if (m2[c-'a']++ == 0) c2++;
        }
        if (Math.abs(c1 - c2) > 2) {
            return false;
        }
        for (int i = 0; i < 26; i++) {
            if (m1[i] == 0) continue;
            for (int j = 0; j < 26; j++) {
                if (m2[j] == 0) continue;
                m1[i]--;
                m2[i]++;
                m1[j]++;
                m2[j]--;
                if (equals(m1, m2)) return true;
                m1[i]++;
                m2[i]--;
                m1[j]--;
                m2[j]++;
            }
        }
        return false;
    }
    static boolean equals(int[] m1, int[] m2) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < 26; i++) {
            if (m1[i] > 0) c1++;
        }
        for (int i = 0; i < 26; i++) {
            if (m2[i] > 0) c2++;
        }
        return c1 == c2;
    }
}