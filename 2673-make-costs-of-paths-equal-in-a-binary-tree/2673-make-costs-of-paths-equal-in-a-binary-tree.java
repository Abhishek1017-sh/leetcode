class Solution {
    int sum=0;
    public int minIncrements(int n, int[] cost) {
        solve(1,n,cost);
        return sum;
    }
    int solve(int node,int n,int[]cost){
        if(node>n){
            return 0;
        }
        int left=solve(2*node,n,cost);
        int right=solve(2*node+1,n,cost);
        sum+=Math.abs(left-right);
        return Math.max(left,right)+cost[node-1];
    }
}