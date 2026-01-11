class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> lis=new ArrayList<>();
        helper(s.toCharArray(),0,lis);
        return lis;
    }
    static void helper(char[] arr,int ind,List<String> lis){
        if(ind==arr.length){
            lis.add(new String(arr));
            return;
        }
        if(Character.isDigit(arr[ind])){
            helper(arr,ind+1,lis);
        }
        else{
            arr[ind]=Character.toLowerCase(arr[ind]);
            helper(arr,ind+1,lis);
            arr[ind]=Character.toUpperCase(arr[ind]);
            helper(arr,ind+1,lis);
        }
    }
}