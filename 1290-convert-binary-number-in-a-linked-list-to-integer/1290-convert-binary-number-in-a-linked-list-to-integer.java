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
    static ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
    public int getDecimalValue(ListNode head) {
        ListNode rev=reverse(head);
        int num=0;
        int c=0;
        while(rev!=null){
            num+=(int)rev.val*(Math.pow(2,c));
            c++;
            rev=rev.next;
        }
        return num;
    }
}