class Solution {
    int first(int arr[],int x){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==x){
                ans=mid;
                end=mid-1;
            }
            else if(arr[mid]>x){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    int last(int arr[],int x){
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==x){
                ans=mid;
                start=mid+1;
            }
            else if(arr[mid]>x){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int left_occ=first(nums,target);
        int right_occ=last(nums,target);
        int[] answer=new int[2];
        answer[0]=left_occ;
        answer[1]=right_occ;
        return answer;
    }
}