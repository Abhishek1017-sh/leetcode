class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i : nums) {
            ans.put(i, ans.getOrDefault(i, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }
}