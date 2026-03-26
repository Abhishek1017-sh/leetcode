class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] map=new int[26];
        for(int i=0;i<order.length();i++){
            map[order.charAt(i)-'a']=i;
        }
        for(int i=1;i<words.length;i++){
            String s1=words[i-1];
            String s2=words[i];
            if(!isSorted(s1,s2,map)){
                return false;
            }
        }
        return true;
    }
    static boolean isSorted(String s1,String s2,int[] map){
        int len=Math.min(s1.length(),s2.length());
        for(int i=0;i<len;i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                return map[s1.charAt(i)-'a']<map[s2.charAt(i)-'a'];
            }
        }
        return s1.length()<=s2.length();
    }
}
