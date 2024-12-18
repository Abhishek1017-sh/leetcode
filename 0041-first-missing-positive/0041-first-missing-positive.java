class Solution {
    public int firstMissingPositive(int[] nums) {
        int a = Arrays.stream(nums).max().orElse(0);
        if (a < 1) {
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= a; i++) {
            map.put(i, 0);
        }
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, 1);
            }
        }
        for (int i = 1; i <= a; i++) {
            if (map.get(i) == 0) {
                return i;
            }
        }
        return a + 1;
    }
}