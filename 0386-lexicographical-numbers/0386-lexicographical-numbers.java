class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=9;i++){
            helper(i,n,ans);
        }
        return ans;
    }
    static void helper(int curr,int limit,List<Integer>ans){
        if(curr>limit) return;
        ans.add(curr);
        for(int i=0;i<=9;i++){
            int num=curr*10+i;
            if(num<=limit){
                helper(num,limit,ans);
            }
            else{
                break;
            }
        }
    }
}