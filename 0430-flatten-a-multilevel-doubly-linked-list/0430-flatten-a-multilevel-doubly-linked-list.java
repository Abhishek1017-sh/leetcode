/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }
    static Node dfs(Node head){
        Node curr=head;
        Node last=null;
        while(curr!=null){
            Node next=curr.next;
            if(curr.child!=null){
                Node childtail=dfs(curr.child);

                curr.next=curr.child;
                curr.child.prev=curr;

                if(next!=null){
                    childtail.next=next;
                    next.prev=childtail;
                }

                curr.child=null;
                last=childtail;
            }
            else{
                last=curr;
            }
            curr=next;
        }
        return last;
    }
}