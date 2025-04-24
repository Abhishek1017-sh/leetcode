class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int totalDistinct = (int) Arrays.stream(nums).distinct().count();
        int res = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums[j]);
                if (set.size() == totalDistinct) {
                    res++;
                }
            }
        }
        return res;
    }
}