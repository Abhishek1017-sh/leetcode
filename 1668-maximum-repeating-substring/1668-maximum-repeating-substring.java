class Solution {
    public int maxRepeating(String sequence, String word) {
        int cnt=0;
        int ans=0;
        int len=word.length();
        int i=0;
        int j=len;
        while(j<=sequence.length()){
            if(sequence.substring(i,j).equals(word)){
                cnt++;
                ans=Math.max(ans,cnt);
                i=j;
                j+=len;
            }
            else{
                cnt=0;
                i++;
                j=i+len;
            }
        }
        return ans;
    }
}