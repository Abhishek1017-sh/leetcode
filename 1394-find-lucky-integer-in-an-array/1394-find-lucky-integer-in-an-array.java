class Solution {
    public int findLucky(int[] arr) {
        int[] help=new int[501];
        for(int i:arr){
            help[i]++;
        }
        int c=-1;
        for(int i=1;i<help.length;i++){
            if(help[i]==i){
                c=Math.max(i,c);
            }
        }
        return c;
    }
}