class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        char[] result = s.toCharArray();
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];
            for (int i = start; i <= end; i++) {
                if (direction == 1) {
                    result[i] = (char) ('a' + (result[i] - 'a' + 1) % 26);
                } else {
                    result[i] = (char) ('a' + (result[i] - 'a' - 1 + 26) % 26);
                }
            }
        }
        return new String(result);
    }
}