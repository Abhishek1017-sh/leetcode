class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[] k = new int[nums.length];
        int[] s = new int[nums.length];
        Arrays.sort(nums);
        for(int i = 0;i<s.length;i++){
            s[i] = -1;
        }
        int max = 0;
        calc(nums,0,k,s);
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            if(max<k[i]){
                index = i;
                max = k[i];
            }
        }
        List<Integer> ret = new ArrayList<>();
        while(index!=-1){
            ret.add(nums[index]);
            index = s[index];
        }
        return ret;
    }
    private static void calc(int[] nums, int ci, int[] k, int[] s){
        if(ci==nums.length) return;
        int max = 0;
        for(int i = 0;i<ci;i++){
            if(nums[ci]%nums[i]==0){
                if(k[ci]<k[i]+1){
                    k[ci] = k[i]+1;
                    s[ci] = i;
                }
            }
        }
        calc(nums,ci+1,k,s);
    }
}