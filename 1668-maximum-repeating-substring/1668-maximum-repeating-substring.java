class Solution {
    public int maxRepeating(String sequence, String word) {
        int cnt=0;
        int ans=0;
        int len=word.length();
        int i=0;
        int j=len;
        int start=0;
        while(j<=sequence.length()){
            if(sequence.substring(i,j).equals(word)){
                cnt++;
                ans=Math.max(ans,cnt);
                i=j;
                j+=len;
            }
            else{
                start++;
                cnt=0;
                i=start;
                j=i+len;
            }
        }
        return ans;
    }
}