/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode doubleIt(ListNode head) {
        head=reverse(head);
        int carry=0;
        ListNode curr=head;
        while(curr!=null){
            int num=curr.val*2+carry;
            curr.val=num%10;
            carry=num/10;
            if(curr.next==null){
                if(carry>0){
                    curr.next=new ListNode(carry);
                }
                break;
            }
            curr=curr.next;
        }
        return reverse(head);
    }
    static ListNode reverse(ListNode head){
        ListNode prev=null;
        while(head!=null){
            ListNode next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
    }
}