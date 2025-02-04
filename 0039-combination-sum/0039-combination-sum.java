class Solution {
    static void helper(int[] arr,int target,List<List<Integer>> ans,List<Integer> curr,int ind){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        if(target>=arr[ind]){
            curr.add(arr[ind]);
            helper(arr,target-arr[ind],ans,curr,ind);
            curr.remove(curr.size()-1);
        }
        helper(arr,target,ans,curr,ind+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(candidates,target,ans,curr,0);
        return ans;
    }
}