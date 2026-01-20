class Solution {
    public int maximumLength(String s) {
        int n=s.length();
        List<Integer>[] f=new ArrayList[26];
        for(int i=0;i<26;i++)f[i]=new ArrayList<>();
        int i=0;
        while(i<n){
            int j=i;
            while(j<n&&s.charAt(j)==s.charAt(i))j++;
            f[s.charAt(i)-'a'].add(j-i);
            i=j;
        }
        int ans=-1;
        for(int c=0;c<26;c++){
            if(f[c].isEmpty())continue;
            f[c].sort(Collections.reverseOrder());
            int a=f[c].get(0);
            ans=Math.max(ans,a-2);
            if(f[c].size()>=2){
                int b=f[c].get(1);
                ans=Math.max(ans,Math.min(a-1,b));
            }
            if(f[c].size()>=3)ans=Math.max(ans,f[c].get(2));
        }
        return ans<=0?-1:ans;
    }
}