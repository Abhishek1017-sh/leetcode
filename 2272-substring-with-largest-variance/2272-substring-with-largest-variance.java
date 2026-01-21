class Solution {
    public int largestVariance(String s) {
        int n=s.length();
        int ans=0;
        for(int x=0;x<26;x++){
            for(int y=0;y<26;y++){
                if(x==y)continue;
                int cx=0,cy=0,ry=0;
                for(int i=0;i<n;i++)if(s.charAt(i)-'a'==y)ry++;
                for(int i=0;i<n;i++){
                    int c=s.charAt(i)-'a';
                    if(c==x)cx++;
                    else if(c==y){cy++;ry--;}
                    if(cy>0)ans=Math.max(ans,cx-cy);
                    if(cx-cy<0&&ry>0){
                        cx=0;
                        cy=0;
                    }
                }
            }
        }
        return ans;
    }
}