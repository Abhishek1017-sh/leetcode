class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int c=0;
        for(int i=low;i<=high;i++){
            String s=Integer.toString(i);
            int len=s.length();
            if(len%2!=0) continue;
            int half=len/2;
            int left=0;
            int right=0;
            for(int j=0;j<half;j++){
                left+=s.charAt(j)-'0';
            }
            for(int j=half;j<len;j++){
                right+=s.charAt(j)-'0';
            }
            if(left==right){
                c++;
            }
        }
        return c;
    }
}