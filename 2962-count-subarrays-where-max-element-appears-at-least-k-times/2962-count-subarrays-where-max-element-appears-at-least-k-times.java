class Solution {
    public long countSubarrays(int[] nums, int k) {
        long c=0;
        int kcount=0;
        int left=0;
        int max=Arrays.stream(nums).max().getAsInt();
        for(int right=0;right<nums.length;right++){
            if(nums[right]==max){
                kcount++;
            }
            while(kcount==k){
                if(nums[left]==max){
                    kcount--;
                }
                left++;
            }
            c+=left;
        }
        return c;
    }
}