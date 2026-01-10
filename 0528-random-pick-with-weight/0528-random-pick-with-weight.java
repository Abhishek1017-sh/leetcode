class Solution {
    int[] prefix;
    int total;
    Random rand=new Random();
    public Solution(int[] w) {
        prefix =new int[w.length];
        int sum=0;
        for(int i=0;i<w.length;i++){
            sum+=w[i];
            prefix[i]=sum;
        }
        total=sum;
    }
    
    public int pickIndex() {
        int target=rand.nextInt(total)+1;
        int low=0, high=prefix.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(prefix[mid]<target){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */