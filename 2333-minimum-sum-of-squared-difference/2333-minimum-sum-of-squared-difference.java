class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        int k=k1+k2;
        int[] diff=new int[n];
        int maxdiff=0;
        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            maxdiff=Math.max(maxdiff,diff[i]);
        }
        long[] freq=new long[maxdiff+1];
        for(int d:diff){
            freq[d]++;
        }
        for(int i=maxdiff;i>0 && k>0;i--){
            if(freq[i]==0) continue;
            long moves=Math.min(freq[i],k);
            freq[i]-=moves;
            freq[i-1]+=moves;
            k-=moves;
        }
        long ans=0;
        for(int i=0;i<=maxdiff;i++){
            ans+=freq[i]*i*i;
        }
        return ans;
    }
}