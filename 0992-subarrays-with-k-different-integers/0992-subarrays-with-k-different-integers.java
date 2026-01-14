class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmostk(nums,k)-atmostk(nums,k-1);

    }
    private static int atmostk(int nums[],int k){
        if(k<0) return 0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        int left=0;
        int c=0;
        for(int right=0;right<nums.length;right++){
            hm.put(nums[right],hm.getOrDefault(nums[right],0)+1);
            while(hm.size()>k){
                hm.put(nums[left],hm.get(nums[left])-1);
                if(hm.get(nums[left])==0){
                    hm.remove(nums[left]);
                }
                left++;
            }
            c+=(right-left+1);
        }
        return c;
    }
}