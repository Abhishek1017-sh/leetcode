class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> ans=new HashSet<>();
        int l=tiles.length();
        boolean[] visited= new boolean[l];
        helper(tiles,"",visited,ans);
        return ans.size()-1;
    }
    public void helper(String tiles,String current,boolean[] visited,
    Set<String> ans){
        ans.add(current);
        for(int i=0;i<tiles.length();i++){
            if(!visited[i]){
                visited[i]=true;
                helper(tiles,current+tiles.charAt(i),visited,ans);
                visited[i]=false;
            }
        }
    }
}