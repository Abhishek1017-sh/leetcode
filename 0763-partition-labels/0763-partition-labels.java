class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int partitionEnd = 0, partitionStart = 0;
        for (int i = 0; i < s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, lastIndex[s.charAt(i) - 'a']);
            if (i == partitionEnd) {
                ans.add(i - partitionStart + 1);
                partitionStart = i + 1;
            }
        }
        return ans;
    }
}