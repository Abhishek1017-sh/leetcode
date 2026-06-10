class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list=new ArrayList<>();
        if(numRows<=0) return list;
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for(int i=1;i<numRows;i++){
            List<Integer> prev=list.get(i-1);
            List<Integer> newrow=new ArrayList<>();
            newrow.add(1);
            for(int j=1;j<i;j++){
                newrow.add(prev.get(j-1)+prev.get(j));
            }
            newrow.add(1);
            list.add(newrow);
        }
        return list;
    }
}