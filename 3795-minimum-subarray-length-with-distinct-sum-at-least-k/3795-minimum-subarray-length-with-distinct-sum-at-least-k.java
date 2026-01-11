class Solution {
    public int minLength(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int ans=Integer.MAX_VALUE;
        int d=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int r=0;r<nums.length;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            if(map.get(nums[r])==1){
                d+=nums[r];
            }
            while(d>=k){
                ans=Math.min(ans,r-l+1);
                int val=nums[l];
                map.put(val,map.get(val)-1);
                if(map.get(val)==0){
                    d-=val;
                }
                l++;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}