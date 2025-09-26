class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo=1;
        int hi=0;
        for(int i:piles){
            hi=Math.max(hi,i);
        }
        int ans=-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            long hrs=0;
            for(int i:piles){
                hrs+=(i+mid-1)/mid;
            }
            if(hrs<=h){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
}