class Solution {
    public String alphabetBoardPath(String target) {
        int curRow = 0, curCol = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : target.toCharArray()) {
            int targetRow = (ch - 'a') / 5;
            int targetCol = (ch - 'a') % 5;
            if (ch == 'z') {
                while (curCol > targetCol) {
                    sb.append('L');
                    curCol--;
                }
                while (curRow < targetRow) {
                    sb.append('D');
                    curRow++;
                }
            } 
            else {
                while (curRow > targetRow) {
                    sb.append('U');
                    curRow--;
                }
                while (curRow < targetRow) {
                    sb.append('D');
                    curRow++;
                }
                while (curCol > targetCol) {
                    sb.append('L');
                    curCol--;
                }
                while (curCol < targetCol) {
                    sb.append('R');
                    curCol++;
                }
            }
            sb.append('!');
        }
        return sb.toString();
    }
}