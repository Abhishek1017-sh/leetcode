class Pair{
    String first;
    int second;
    Pair(String first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        Queue<Pair> que=new LinkedList<>();
        for(String i:wordList){
            set.add(i);
        }
        que.add(new Pair(beginWord,1));
        set.remove(beginWord);
        while(!que.isEmpty()){
            String word=que.peek().first;
            int cnt=que.peek().second;
            que.remove();
            if(word.equals(endWord)==true) return cnt;
            for(int i=0;i<word.length();i++){
                for(char j='a';j<='z';j++){
                    char[] split_word=word.toCharArray();
                    split_word[i]=j;
                    String reword=new String(split_word);
                    if(set.contains(reword)){
                        que.add(new Pair(reword,cnt+1));
                        set.remove(reword);
                    }
                }
            }
        }
        return 0;
    }
}