class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int case1 = findMaxSum(nums, 0, n - 2);
        int case2 = findMaxSum(nums, 1, n - 1);
        return Math.max(case1, case2);
    }
    private int findMaxSum(int arr[], int start, int end) {
        int len = end - start + 1;
        if (len == 1) return arr[start];
        if (len == 2) return Math.max(arr[start], arr[start + 1]);
        int[] store = new int[len];
        store[0] = arr[start];
        store[1] = Math.max(arr[start], arr[start + 1]);
        for (int i = 2; i < len; i++) {
            store[i] = Math.max(store[i - 1], store[i - 2] + arr[start + i]);
        }
        return store[len - 1];
    }
}