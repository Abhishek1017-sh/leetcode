class Solution {
    public boolean isValidSudoku(char[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (mat[i][j] != '.') {
                    int num = mat[i][j];
                    if (validr(num, i, j, mat) || 
                        validc(num, i, j, mat) || 
                        validm(num, i, j, mat)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    static boolean validr(int num, int i, int j, char[][] mat) {
        for (int c = 0; c < 9; c++) {
            if (mat[i][c] == num && c != j) {
                return true;
            }
        }
        return false;
    }
    static boolean validc(int num, int i, int j, char[][] mat) {
        for (int r = 0; r < 9; r++) {
            if (mat[r][j] == num && r != i) {
                return true;
            }
        }
        return false;
    }
    static boolean validm(int num, int i, int j, char[][] mat) {
        int bsr = 3 * (i / 3);
        int bsc = 3 * (j / 3);
        for (int m = 0; m < 9; m++) {
            int nr = bsr + m / 3;
            int nc = bsc + m % 3;
            if (mat[nr][nc] == num && (nr != i || nc != j)) {
                return true;
            }
        }
        return false;
    }
}