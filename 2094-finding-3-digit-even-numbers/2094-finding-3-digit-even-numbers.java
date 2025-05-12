class Solution {
    public int[] findEvenNumbers(int[] digits) {
       Set<Integer> map=new HashSet<>();
       for(int i=0;i<digits.length;i++){
        for(int j=0;j<digits.length;j++){
            for(int k=0;k<digits.length;k++){
                if(i==j || j==k || i==k){
                    continue;
                }
                int num=digits[i]*100+digits[j]*10+digits[k];
                if(num>=100 && num%2==0){
                    map.add(num);
                }
            }
        }
       }
       List<Integer> ans=new ArrayList<>(map);
        Collections.sort(ans);
        int[] answ=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answ[i]=ans.get(i);
        }
        return answ;
    }
}