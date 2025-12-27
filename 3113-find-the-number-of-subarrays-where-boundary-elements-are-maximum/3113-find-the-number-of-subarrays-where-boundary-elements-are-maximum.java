class Solution {
    public long numberOfSubarrays(int[] nums) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        long res = 0;
        for (int a : nums) {
            while (!stack.isEmpty() && stack.peek()[0] < a)
                stack.pop();
            if (stack.isEmpty() || stack.peek()[0] != a)
                stack.push(new int[]{a, 0});
            res += ++stack.peek()[1];
        }
        return res;
    }
}