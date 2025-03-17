class Solution {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        if(s.length()==0) return true;
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='[' || ch=='{' || ch=='('){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;
                char top=st.peek();
                if(top=='[' && ch==']' || top=='{' && ch=='}' || top=='(' && ch==')'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        return st.size()==0;
    }
}