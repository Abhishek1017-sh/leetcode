class Solution {
    public int maxVowels(String s, int k) {
        int i=0;
        int j=0;
        int len=0;
        String vow="aeiou";
        int count=0;
        while(j<s.length()){
            
            if(vow.contains(String.valueOf(s.charAt(j)))){
                count++;
            }
            if(j-i+1==k){
                len=Math.max(len,count);
                if(vow.contains(String.valueOf(s.charAt(i)))){
                    count--;
                }
                i++;
            }
            j++;
            
        }
        return len;
    }
}