class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int i=num1.length()-1,j=num2.length()-1;
        int carry=0;
        while(i>=0 || j>=0 || carry>0){
            int one=(i>=0) ? num1.charAt(i)-'0':0;
            int two=(j>=0) ? num2.charAt(j)-'0':0;
            int s=one+two+carry;
            sum.append(s%10);
            carry=s/10;
            i--;
            j--;
        }
        return sum.reverse().toString();
    }
}