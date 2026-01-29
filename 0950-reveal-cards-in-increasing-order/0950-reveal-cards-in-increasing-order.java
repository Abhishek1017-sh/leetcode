class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=deck.length-1;i>=0;i--){
            if(!dq.isEmpty()){
                dq.addFirst(dq.pollLast());
            }
            dq.addFirst(deck[i]);
        }
        int[] ans=new int[deck.length];
        int ind=0;
        while(!dq.isEmpty()){
            ans[ind++]=dq.pollFirst();
        }
        return ans;
    }
}