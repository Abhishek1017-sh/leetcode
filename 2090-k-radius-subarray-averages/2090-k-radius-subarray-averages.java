class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        int win = 2 * k + 1;
        if (n < win) return ans;

        long sum = 0;
        for (int idx = 0; idx < win; idx++) sum += nums[idx];
        ans[k] = (int)(sum / win);
        for (int right = win; right < n; right++) {
            sum += nums[right];
            sum -= nums[right - win];
            ans[right - k] = (int)(sum / win);
        }

        return ans;
    }
}
