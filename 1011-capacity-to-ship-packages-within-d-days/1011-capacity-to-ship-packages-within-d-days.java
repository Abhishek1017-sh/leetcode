class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=1;
        int h=0;
        for(int i:weights){
            l=Math.max(l,i);
            h+=i;
        }
        int ans=0;
        while(l<=h){
            int rcap=l+(h-l)/2;
            int day=1;
            if(isPossible(weights,days,rcap)){
                ans=rcap;
                h=rcap-1;
            }
            else{
                l=rcap+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int[] weights,int days,int cap){
        int day = 1;
        int load = 0;
        for (int w : weights) {
            if (load + w > cap) { 
                day++;
                load = 0;
            }
            load += w;
            if (day > days) return false;
        }
        return true;   
    }
}