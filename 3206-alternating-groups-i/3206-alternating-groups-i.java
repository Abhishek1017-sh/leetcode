class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int n=colors.length;
        int[] arr=new int[n+2];
        for(int i=0;i<n+2;i++){
            arr[i]=colors[i%n];
        }
        int i=0;
        int j=0;
        int count=0;
        while(j<arr.length){
            if(j-i+1==3){
                if(arr[i]==arr[j] && arr[j]!=arr[j-1]){
                    count++;
                    i++;
                }
                else{
                    i++;
                }
            }
            j++;
        }
        return count;
    }
}