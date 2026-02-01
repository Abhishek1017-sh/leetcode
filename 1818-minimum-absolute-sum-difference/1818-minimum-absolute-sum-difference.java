class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = 1_000_000_007;
        int n = nums1.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(nums1[i] - nums2[i]);
        }
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        int maxGain = 0;
        for (int i = 0; i < n; i++) {
            int currentDiff = Math.abs(nums1[i] - nums2[i]);
            int idx = Arrays.binarySearch(sorted, nums2[i]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            if (idx < n) {
                int newDiff = Math.abs(sorted[idx] - nums2[i]);
                maxGain = Math.max(maxGain, currentDiff - newDiff);
            }
            if (idx > 0) {
                int newDiff = Math.abs(sorted[idx - 1] - nums2[i]);
                maxGain = Math.max(maxGain, currentDiff - newDiff);
            }
        }
        return (int) ((sum - maxGain) % MOD);
    }
}