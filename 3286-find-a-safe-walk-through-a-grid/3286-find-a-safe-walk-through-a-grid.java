class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] healths = new int[m][n];
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        queue.offer(new int[] { 0, 0, health - grid.get(0).get(0) });
        while(!queue.isEmpty()) {
            int[] curr = queue.poll();
            if(curr[2] == 0){
                continue;
            }
            if(curr[0] == m - 1 && curr[1] == n - 1){
                return true;
            }
            for(int[] dir : dirs) {
                int newX = curr[0] + dir[0], newY = curr[1] + dir[1];
                if(newX < 0 || newY < 0 || newX >= m || newY >= n){
                    continue;
                }
                int newHealth = curr[2] - grid.get(newX).get(newY);
                if(healths[newX][newY] >= newHealth){
                    continue;
                }
                healths[newX][newY] = newHealth;
                queue.offer(new int[] { newX, newY, newHealth });
            }
        }
        return false;
    }
}