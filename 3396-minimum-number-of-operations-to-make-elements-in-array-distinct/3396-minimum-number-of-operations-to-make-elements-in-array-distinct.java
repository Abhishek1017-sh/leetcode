class Solution {
    static boolean distinct(int[] nums,int i){
        Set<Integer> set = new HashSet<>();
        for (int j = i;j < nums.length; j++) {
            if (set.contains(nums[j])) return false;
            set.add(nums[j]);
        }
        return true;
    }
    public int minimumOperations(int[] nums) {
        int c=0;
        for(int i=0;i<nums.length;i+=3){
            if(distinct(nums,i)){
                return c;
            }
            c++;
        }
        return c;
    }
}