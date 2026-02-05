class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int[] freq=new int[51];
        ArrayList<Integer> result=new ArrayList<>();
        int start=0;
        for(int end=0;end<n;end++){
            if(nums[end]<0){
                freq[Math.abs(nums[end])]++;
            }
            if(end-start+1==k){
                int count=0;
                int value=0;
                for(int v=50;v>=1;v--){
                    count+=freq[v];
                    if(count>=x){
                        value=-v;
                        break;
                    }
                }
                result.add(count>=x?value:0);
                if(nums[start]<0){
                    freq[Math.abs(nums[start])]--;
                }
                start++;
            }
        }
        int[] ans=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
        return ans;
    }
}