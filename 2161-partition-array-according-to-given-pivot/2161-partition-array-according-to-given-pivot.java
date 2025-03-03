class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left=0;
        int equal=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                left++;
            }
            else if(nums[i]==pivot){
                equal++;
            }
        }
        int right=left+equal;
        int[] ans=new int[nums.length];
        int d=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                ans[d]=nums[i];
                d++;
            }
            else if(nums[i]==pivot){
                ans[left]=nums[i];
                left++;
            }
            else{
                ans[right]=nums[i];
                right++;
            }
        }
        return ans;
    }
}