class Solution {
    public int minOperations(int[][] grid, int x) {
        ArrayList<Integer> numsArray = new ArrayList<>();
        int result = Integer.MAX_VALUE;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] % x != grid[0][0] % x) return -1;
                numsArray.add(grid[row][col]);
            }
        }
        Collections.sort(numsArray);
        int length = numsArray.size();
        int[] prefixSum = new int[length];
        int[] suffixSum = new int[length];
        for (int index = 1; index < length; index++) {
            prefixSum[index] = prefixSum[index - 1] + numsArray.get(index - 1);
        }
        for (int index = length - 2; index >= 0; index--) {
            suffixSum[index] = suffixSum[index + 1] + numsArray.get(index + 1);
        }
        for (int index = 0; index < length; index++) {
            int leftOperations =
                (numsArray.get(index) * index - prefixSum[index]) / x;
            int rightOperations =
                (suffixSum[index] -
                    numsArray.get(index) * (length - index - 1)) /
                x;
            result = Math.min(result, leftOperations + rightOperations);
        }
        return result;
    }
}