/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(root);
        while(queue.size()>0){
            List<Integer> ls=new ArrayList<>();
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeNode n=queue.poll();
                ls.add(n.val);
                if(n.left!=null){
                    queue.add(n.left);
                }
                if(n.right!=null){
                    queue.add(n.right);
                }
            }
            list.add(ls);
        }
        for(int i=1;i<list.size();i+=2){
            Collections.reverse(list.get(i));
        }
        return list;
    }
}