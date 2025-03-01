class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int zero=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1] && nums[i]!=0){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        for(int num:nums){
            if(num!=0){
                ans[zero]=num;
                zero++;
            }
        }
        while(zero<n){
            ans[zero]=0;
            zero++;
        }
        return ans;
    }
}