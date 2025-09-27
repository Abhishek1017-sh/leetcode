class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int l=1;
        int h = (int)1e7;
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPoss(dist,hour,mid)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    static boolean isPoss(int[] dist,double hour,int mid){
        double time=0;
        int n=dist.length;
        for(int i=0;i<n;i++){
            if(i==n-1){
                 time+=(double)dist[i]/mid;
            }
            else{
                time+=Math.ceil((double)dist[i]/mid); 
            }
        }
        return time<=hour;
    }
}