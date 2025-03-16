class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low=1;
        long high=0;
        for(int i=0;i<ranks.length;i++){
            high=Math.max(high,ranks[i]);
        }
        high=high*cars*cars;
        long ans=0;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(is_it_pos(ranks,mid,cars)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static boolean is_it_pos(int[] ranks,long mid,int cars){
        long count=0;
        for(int i=0;i<ranks.length;i++){
            long k=(int) Math.sqrt(mid/ranks[i]);
            count+=k;
        }
        return count>=cars;
    }
}