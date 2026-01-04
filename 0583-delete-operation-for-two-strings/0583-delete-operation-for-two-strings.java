class Solution {
    public int minDistance(String word1, String word2) {
        return rec(word1,word2);
    }
    static int rec(String word1,String word2){
        if(word1.length()==0 && word2.length()==0){
            return 0;
        }
        if(word1.length()==0 && word2.length()!=0){
            return word2.length();
        }
        if(word2.length()==0 && word1.length()!=0){
            return word1.length();
        }
        if(word1.charAt(0)==(word2.charAt(0))){
            return rec(word1.substring(1),word2.substring(1));
        }
        return Math.min(1+rec(word1.substring(1),word2),1+rec(word1,word2.substring(1)));
    }
}