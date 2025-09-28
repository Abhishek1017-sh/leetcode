class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> map=new HashSet<>();
        for(int e:nums){
            map.add(e);
        }
        int dis=map.size();
        int count=0;
        for(int k=dis;k<=nums.length;k++){
            int i=0;
            int j=0;
            HashMap<Integer,Integer> check=new HashMap<>();
            while(j<nums.length){
                check.put(nums[j],check.getOrDefault(nums[j],0)+1);
                if(j-i+1==k){
                    if(check.size()==dis) count++;
                    check.put(nums[i],check.get(nums[i])-1);
                    if(check.get(nums[i])==0){
                        check.remove(nums[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        return count;
    }
}