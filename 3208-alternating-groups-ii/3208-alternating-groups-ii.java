class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int[] ext=new int[colors.length+k-1];
        for(int i=0;i<colors.length;i++){
            ext[i]=colors[i];
        }
        for(int i=0;i<k-1;i++){
            ext[colors.length+i]=colors[i];
        }
        int l=ext.length;
        int ans=0;
        int left=0;
        int right=1;
        while(right<l){
            if(ext[right]==ext[right-1]){
                left=right;
                right++;
                continue;
            }
            right++;
            if(right-left<k) continue;
            ans++;
            left++;
        }
        return ans;
    }
}