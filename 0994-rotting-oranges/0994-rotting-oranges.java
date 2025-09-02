class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty() && freshOranges > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nextRow = curr[0] + dir[0];
                    int nextCol = curr[1] + dir[1];
                    if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < cols && grid[nextRow][nextCol] == 1) {
                        grid[nextRow][nextCol] = 2;
                        q.offer(new int[]{nextRow, nextCol});
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }

        return freshOranges == 0 ? minutes : -1;
    }
}