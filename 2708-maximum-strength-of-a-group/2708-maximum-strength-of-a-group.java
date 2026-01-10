class Solution {
    public long maxStrength(int[] nums) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        for(int n:nums){
            if(n<0){
                neg.add(n);
            }
            else if(n>0){
                pos.add(n);
            }
        }
        neg.sort((a,b)->Math.abs(a)-Math.abs(b));
        if(neg.size()%2!=0){
            neg.remove(0);
        }
        if(pos.isEmpty() && neg.isEmpty()){
            int max=nums[0];
            for(int n:nums) max=Math.max(max,n);
            return max;
        }
        long pro=1;
        for(int n:pos)pro*=n;
        for(int n:neg)pro*=n;
        return pro;
    }
}