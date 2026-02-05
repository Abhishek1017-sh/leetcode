class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        int n=transactions.length;
        String[] name=new String[n];
        int[] time=new int[n];
        int[] amount=new int[n];
        String[] city=new String[n];
        boolean[] bad=new boolean[n];
        for(int i=0;i<n;i++){
            String[] t=transactions[i].split(",");
            name[i]=t[0];
            time[i]=Integer.parseInt(t[1]);
            amount[i]=Integer.parseInt(t[2]);
            city[i]=t[3];
            if(amount[i]>1000) bad[i]=true;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(name[i].equals(name[j]) &&
                   Math.abs(time[i]-time[j])<=60 && !city[i].equals(city[j])){
                    bad[i]=true;
                    bad[j]=true;
                }
            }
        }
        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(bad[i]) ans.add(transactions[i]);
        }
        return ans;
    }
}