class Solution {
    public int minimumLength(String s) {
        if(s.length()<3){
            return s.length();
        }
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int c=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()%2==0){
                c+=2;
            }
            else{
                c+=1;
            }
        }
        return c;
    }
}