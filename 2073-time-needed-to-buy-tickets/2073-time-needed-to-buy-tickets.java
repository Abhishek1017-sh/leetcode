class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<int[]> que=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            que.add(new int[]{tickets[i],i});
        }
        int c=0;
        while(!que.isEmpty()){
            int[] curr=que.poll();
            int a=curr[0];
            int b=curr[1];
            c++;
            a--;
            if(a==0 && b==k){
                return c;
            }
            if(a>0){
                que.add(new int[]{a,b});
            }
        }
        return c;
    }
}