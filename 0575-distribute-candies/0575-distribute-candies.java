class Solution {
    public int distributeCandies(int[] candyType) {
        int len=candyType.length/2;
        HashSet<Integer> set=new HashSet<>();
        for(int i:candyType){
            set.add(i);
        }
        int n=set.size();
        if(n<len){
            return n;
        }
        else{
            return len;
        }

    }
}