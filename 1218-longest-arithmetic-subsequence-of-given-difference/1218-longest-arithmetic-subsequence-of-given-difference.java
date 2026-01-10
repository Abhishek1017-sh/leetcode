class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer,Integer> dp=new HashMap<>();
        int ans=0;
        for(int n:arr){
            int prev=dp.getOrDefault(n-difference,0);
            int curr=prev+1;
            dp.put(n,curr);
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}