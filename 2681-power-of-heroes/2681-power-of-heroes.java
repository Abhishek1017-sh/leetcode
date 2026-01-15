class Solution {
    public int sumOfPower(int[] nums) {
        long mod=1000000007;
        Arrays.sort(nums);
        long ans=0;
        long s=0;
        for(int i=0;i<nums.length;i++){
            long x=nums[i];
            ans=(ans+(x*x)%mod * (s+x)%mod)%mod;
            s=(s*2+x)%mod;
        }
        return (int) ans;
    }
}