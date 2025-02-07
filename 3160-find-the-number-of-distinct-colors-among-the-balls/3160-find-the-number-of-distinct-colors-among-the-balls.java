class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        int[] ans = new int[queries.length];
        Map<Integer, Integer> ballColor = new HashMap<>();
        Map<Integer, Integer> colorCount = new HashMap<>();
        Set<Integer> uniqueColors = new HashSet<>(); 
        for (int i = 0; i < queries.length; i++) {
            int ball = queries[i][0];
            int newColor = queries[i][1];
            if (ballColor.containsKey(ball)) {
                int oldColor = ballColor.get(ball);
                colorCount.put(oldColor, colorCount.get(oldColor) - 1);
                if (colorCount.get(oldColor) == 0) {
                    uniqueColors.remove(oldColor);
                }
            }
            ballColor.put(ball, newColor);
            colorCount.put(newColor, colorCount.getOrDefault(newColor, 0) + 1);
            uniqueColors.add(newColor);
            ans[i] = uniqueColors.size();
        }
        return ans;
    }
}