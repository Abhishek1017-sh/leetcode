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
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr=new ArrayList<>();
        while(head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int n=arr.size();
        int[] ans=new int[n];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && arr.get(dq.peek())<arr.get(i)){
                ans[dq.pop()]=arr.get(i);
            }
            dq.push(i);
        }
        return ans;
    }
}