class Solution {
    public int subarraySum(int[] nums, int k) {
        int c=0;
        int i=0,j=0;
        int sum=0;
        while(j<nums.length){
            sum+=nums[j];
            while(sum>k && i<=j){
                sum-=nums[i];
                i++;
            }
            if(sum==k && i <= j){
                c++;
            }
            j++;
        }
        return c;
    }
}