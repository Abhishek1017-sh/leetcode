class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>();
        Queue<Object[]> que=new LinkedList<>();
        for(String i:wordList){
            set.add(i);
        }
        que.add(new Object[]{beginWord,1});
        set.remove(beginWord);
        while(!que.isEmpty()){
            Object[] pair=que.poll();
            String word=(String)pair[0];
            int cnt=(int)pair[1];
            for(int i=0;i<word.length();i++){
                for(char j='a';j<='z';j++){
                    char[] split_word=word.toCharArray();
                    split_word[i]=j;
                    String reword=new String(split_word);
                    if(set.contains(reword)){
                        if(reword.equals(endWord)){
                            return cnt+1;
                        }
                        que.add(new Object[]{reword,cnt+1});
                        set.remove(reword);
                    }
                }
            }
        }
        return 0;
    }
}