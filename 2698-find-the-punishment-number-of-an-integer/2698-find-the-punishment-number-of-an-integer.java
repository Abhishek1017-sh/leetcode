class Solution {
    public boolean canPartition(String stringNum, int target) {
        if (stringNum.isEmpty() && target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }
        for (int i=0;i<stringNum.length();i++) {
            String left=stringNum.substring(0,i+1);
            String right=stringNum.substring(i+1);
            int leftNum=Integer.parseInt(left);
            if(canPartition(right,target-leftNum)) {
                return true;
            }
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int ans=0;
        for (int i=1;i<=n;i++) {
            int sq=i*i;
            if (canPartition(Integer.toString(sq),i)){
                ans+=sq;
            }
        }
        return ans;
    }
}