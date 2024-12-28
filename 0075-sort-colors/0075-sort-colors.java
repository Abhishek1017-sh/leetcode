class Solution {
    public void sortColors(int[] nums) {
        int Nonzero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[Nonzero];
                nums[Nonzero]=temp;
                Nonzero++;
            }
        }
        int TwoIdx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=2){
                int temp=nums[i];
                nums[i]=nums[TwoIdx];
                nums[TwoIdx]=temp;
                TwoIdx++;
            }
        }
    }
}