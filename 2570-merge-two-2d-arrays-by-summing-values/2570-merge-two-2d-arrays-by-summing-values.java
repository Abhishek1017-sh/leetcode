class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int[] nums : nums1){
            map.put(nums[0],nums[1]);
        }
        for(int[] nums : nums2){
            map.put(nums[0],map.getOrDefault(nums[0],0)+nums[1]);
        }
        List<int[]> merge=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            merge.add(new int[] {entry.getKey(),entry.getValue()});
        }
        int[][] ans=new int[merge.size()][2];
        for(int i=0;i<merge.size();i++){
            ans[i]=merge.get(i);
        }
        return ans;
    }
}