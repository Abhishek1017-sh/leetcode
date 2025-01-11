class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.isEmpty()){
            return 0;
        }
        int left=0;
        int max=0;
        HashSet<Character> map=new HashSet<>();
        for(int right=0;right<s.length();right++){
            char cu=s.charAt(right);
            while(map.contains(cu)){
                map.remove(s.charAt(left));
                left++;
            }
            map.add(cu);
            max=Math.max(max,right-left+1);
        }
        return max;
    } 
}