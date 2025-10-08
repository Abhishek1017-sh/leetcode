class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l=0;
        long h=(long)1e14;
        long ans=h;
        while(l<=h){
            long mid=l+(h-l)/2;
            if(isPoss(time,mid,totalTrips)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    static boolean isPoss(int[] time,long mid,int trip){
        long t=0;
        for(int ti:time){
            t+=mid/ti;
            if(t>=trip) return true;
        }
        return false;
    }
}