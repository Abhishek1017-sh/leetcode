class Solution {
    static void zero(int arr[][], int arr2[][], int i, int j) {
        for (int z = 0; z < arr.length; z++) {
            arr2[z][j] = 0;
        }
        for (int z = 0; z < arr[0].length; z++) {
            arr2[i][z] = 0;
        }
    }
    public void setZeroes(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int arr2[][] = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr2[i][j] = arr[i][j];
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 0) {
                    zero(arr, arr2, i, j);
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = arr2[i][j];
            }
        }
    }
}