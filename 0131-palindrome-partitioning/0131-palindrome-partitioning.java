class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        sol(s,0,new ArrayList<>(),ans);
        return ans;
    }
    static void sol(String s,int start,List<String> res,List<List<String>> ans){
        if(start==s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalin(s,start,i)){
                res.add(s.substring(start,i+1));
                sol(s,i+1,res,ans);
                res.remove(res.size()-1);
            }
        }
    }
    static boolean isPalin(String s,int start,int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}