class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int l=1;
        int h=0;
        for(int e:bloomDay){
            h=Math.max(h,e);
        }
        int ans=-1;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(isPoss(bloomDay,m,k,mid)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    static boolean isPoss(int[] arr,int m,int k,int mid){
        int bouq=0;
        int flower=0;
        for(int i:arr){
            if(i<=mid) flower++;
            else flower=0;

            if(flower==k){
                bouq++;
                flower=0;
            }
        }
        return bouq>=m;
    }
}