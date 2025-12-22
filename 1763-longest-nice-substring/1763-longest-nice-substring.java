class Solution {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c))
                lower[c - 'a'] = true;
            else
                upper[c - 'A'] = true;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = Character.toLowerCase(c) - 'a';
            if (lower[idx] && upper[idx]) continue;
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));
            return left.length() >= right.length() ? left : right;
        }
        return s;
    }
}