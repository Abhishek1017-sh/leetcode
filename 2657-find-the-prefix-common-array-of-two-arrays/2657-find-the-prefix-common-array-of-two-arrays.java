class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans=new int[A.length];
        Set<Integer> A1=new HashSet<>();
        Set<Integer> B1=new HashSet<>();
        for(int i=0;i<A.length;i++){
            A1.add(A[i]);
            B1.add(B[i]);
            int c=0;
            for(int j:A1){
                if(B1.contains(j)){
                    c++;
                }
            }
            ans[i]=c;
        }
        return ans;
    }
}