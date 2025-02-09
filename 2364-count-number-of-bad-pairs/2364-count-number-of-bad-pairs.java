class Solution {
    public long countBadPairs(int[] nums) {
        long c=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(i<j && j - i != nums[j] - nums[i] ){
                    c+=1;
                }
            }
        }
        return c;
    }
}