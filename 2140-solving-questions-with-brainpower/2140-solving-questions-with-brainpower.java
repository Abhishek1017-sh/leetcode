class Solution {
    static long helper(long i,int[][] arr){
        long c=0;
        long j=i;
        while(j<arr.length){
            c+=arr[(int)j][0];
            j+=arr[(int)j][1]+1;
        }
        return c;
    }
    public long mostPoints(int[][] questions) {
        long max=0;
        for(long i=0;i<questions.length;i++){
            long sum=helper(i,questions);
            max=Math.max(sum,max);
        }
        return max;
    }
}