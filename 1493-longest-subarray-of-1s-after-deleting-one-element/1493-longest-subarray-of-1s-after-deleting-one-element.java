class Solution {
    public int longestSubarray(int[] nums) {
       int i=0;
       int j=0;
       int zero=0;
       int len=0;
       while(j<nums.length){
        if(nums[j]==0) zero++;
        while(zero>1){
            if(nums[i]==0) zero--;
            i++;
        }
        len=Math.max(len,j-i);
        j++;
       }  
       return len;
    }
}