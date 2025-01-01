class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(result,new ArrayList<>(),nums);
        return result;
    }
    private void backtrack(List<List<Integer>> result ,ArrayList<Integer> temp, int[] nums){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i:nums){
            if(temp.contains(i)){
                continue;
            }
            temp.add(i);
            backtrack(result,temp,nums);
            temp.remove(temp.size()-1);
        }
    }
}