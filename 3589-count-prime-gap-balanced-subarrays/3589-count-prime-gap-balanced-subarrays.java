class Solution {
    public int primeSubarray(int[] nums, int k) {
        int n=nums.length;
        int prime=0;
        int lastprime=-1;
        int seclastprime=-1;
        int i=0;
        int ans=0;
        Deque<Integer> min=new LinkedList<>();
        Deque<Integer> max=new LinkedList<>();
        for(int j=0;j<n;j++){
            if(isPrime(nums[j])){
                prime++;
                seclastprime=lastprime;
                lastprime=j;
                while(!min.isEmpty() && min.peekLast()>nums[j]){
                    min.pollLast();
                }
                min.addLast(nums[j]);
                while(!max.isEmpty() && max.peekLast()<nums[j]){
                    max.pollLast();
                }
                max.addLast(nums[j]);
            }
            while(prime>0 && max.peekFirst()-min.peekFirst()>k){
                if(isPrime(nums[i])){
                    prime--;
                    if(min.peekFirst()==nums[i]) min.pollFirst();
                    if(max.peekFirst()==nums[i]) max.pollFirst();
                }
                i++;
            }
            if(prime>=2){
                ans+=seclastprime-i+1;
            }
        }
        return ans;
    }
    static boolean isPrime(int n){
        if(n<=1) return false;
        if(n<=3) return true;
        if(n%2==0 || n%3==0) return false;
        for(int i=5;i*i<=n;i+=6){
            if(n%i==0 || n%(i+2)==0){
                return false;
            }
        }
        return true;
    }
}