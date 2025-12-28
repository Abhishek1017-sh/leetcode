class Solution {
    public long maximumSubsequenceCount(String text, String pattern) {
        long res = 0;
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < text.length(); ++i) {   
            if (text.charAt(i) == pattern.charAt(1)) {   
                res += c1; 
                c2++;
            }
            if (text.charAt(i) == pattern.charAt(0)) {   
                c1++;
            }
        }
        return res + Math.max(c1, c2);
    }
}