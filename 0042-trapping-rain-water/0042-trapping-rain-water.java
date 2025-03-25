class Solution {
    public int trap(int[] arr) {
        int lmax=arr[0];
        int rmax=arr[arr.length-1];
        int left=1;
        int right=arr.length-2;
        int sum=0;
        while(left<=right){
            if(lmax<rmax){
                lmax=Math.max(lmax,arr[left]);
                sum+=(lmax-arr[left]);
                left++;
            }
            else{
                rmax=Math.max(rmax,arr[right]);
                sum+=(rmax-arr[right]);
                right--;
            }
        }
        return sum;
    }
}