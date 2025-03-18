class Solution {
    public int longestNiceSubarray(int[] nums) {
        int len=0;
        int i=0,j=0;
        while(j<nums.length){
            int k=i;
            for(;k<j;k++){
                if((nums[k]&(nums[j]))!=0){
                    i=k+1;
                }
            }
            len=Math.max(len,(j-i+1));
            j++;
        }
        return len;
    }
}