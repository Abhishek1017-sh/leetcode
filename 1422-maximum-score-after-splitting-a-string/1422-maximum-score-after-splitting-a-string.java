class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        int zerosCount = 0;
        int maxScore = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                totalOnes++;
            }
        }
        int onesSeen = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zerosCount++;
            } else {
                onesSeen++;
            }
            int rightOnes = totalOnes - onesSeen;
            int currentScore = zerosCount + rightOnes;
            maxScore = Math.max(maxScore, currentScore);
        }
        return maxScore;
    }
}