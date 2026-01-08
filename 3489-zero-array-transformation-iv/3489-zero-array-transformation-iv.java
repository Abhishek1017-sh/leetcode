class Solution {
    int fun( int iq , int sum ,int i, int queries[][], int dp[][]){
        if(sum==0){
            return iq;
        }
        if(iq >= queries.length || sum <= 0){
            return Integer.MAX_VALUE;
        }
        if(dp[iq][sum] !=-1) {
            return dp[iq][sum]; 
        }
        int res= fun(iq+1, sum,i, queries, dp);
        if( i>= queries[iq][0] && i<= queries[iq][1]){
            res=Math.min(res, fun( iq +1, sum- queries[iq][2] , i , queries, dp ));
        }
        return  dp[iq][sum]=res;
    }
    boolean isPos( int mid, int nums[], int queries[][]){
        for(int i=0;i< nums.length; i++){
            int dp[][]=new int[ queries.length +1 ][ nums[i]+1 ];
            for(int d[] : dp){
                Arrays.fill( d, -1);
            }
            int indx = fun( 0, nums[i] , i, queries, dp);
            if(indx > mid){
                return false;
            }
        }
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int q= queries.length;
        int l= 0; int r= q;
        int ans= -1;
        while( l<=r){
            int mid=  l + (r-l) /2;
            if( isPos( mid, nums, queries)){
                r=mid-1;
                ans=mid;
            }
            else{
                l=mid+1;
            }
        }
        return ans;   
    }
}