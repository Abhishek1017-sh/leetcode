class Solution {
    public int findCenter(int[][] edges) {
        int arr[]=new int[edges.length+2];
        for(int[] i:edges){
            arr[i[0]]++;
            arr[i[1]]++;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==edges.length){
                return i;
            }
        }
        return -1;
    }
}