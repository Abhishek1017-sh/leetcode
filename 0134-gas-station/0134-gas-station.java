class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tgas=0;
        int tcost=0;
        int start=0;
        int curr=0;
        for(int i=start;i<gas.length;i++){
            tgas+=gas[i];
            tcost+=cost[i];
            curr+=gas[i]-cost[i];
            if(curr<0){
                curr=0;
                start=i+1;
            }
        }
        return tgas>=tcost ? start : -1;
    }
}