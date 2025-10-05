class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        sol(nums,new ArrayList<>(),used,ans);
        return ans;
    }
    static void sol(int[] nums,List<Integer> path,boolean[] used,List<List<Integer>> ans){
        if(path.size()==nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]==true) continue;
            used[i]=true;
            path.add(nums[i]);
            sol(nums,path,used,ans);
            path.remove(path.size()-1);
            used[i]=false;
        }
    }
}