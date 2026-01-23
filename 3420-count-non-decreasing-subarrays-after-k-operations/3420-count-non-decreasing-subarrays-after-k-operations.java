class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long res = (long)(1+n)*n/2;
        for(int i = 0; i < n-1; i++){
            int preMax = nums[i], idx = i+1;
            int opt = 0;
            while(idx < n && opt <= k){
                int diff = nums[idx]-preMax;
                if(diff >= 0)
                    preMax = nums[idx];
                else
                    opt -= diff;
                if(opt > k)
                    break;
                idx++;
            }
            if(idx >= n) return res;
            res -= (n-idx);
        }
        return res;
    }
}