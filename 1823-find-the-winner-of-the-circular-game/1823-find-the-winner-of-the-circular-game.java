class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> que=new LinkedList<>();
        for(int i=1;i<n+1;i++){
            que.add(i);
        }
        int co=0;
        while(que.size()!=1){
            int a=que.poll();
            co++;
            if(co!=k){
                que.add(a);
            }
            else if(co==k){
                co=0;
            }
        }
        return que.peek();
    }
}