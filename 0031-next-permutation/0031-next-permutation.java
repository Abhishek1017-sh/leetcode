class Solution {
    void reverse(int[] arr,int l,int r){
        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
    public void nextPermutation(int[] nums) {
        int breakpoint=-1;
        int n= nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                breakpoint=i;
                break;
            }
        }
        if(breakpoint==-1){
            reverse(nums,0,n-1);
            return;
        }
        for(int i=n-1;i>breakpoint;i--){
            if(nums[i]>nums[breakpoint]){
                int temp=nums[breakpoint];
                nums[breakpoint]=nums[i];
                nums[i]=temp;
                break;
            }
        }
        reverse(nums,breakpoint+1,n-1);
    }
}