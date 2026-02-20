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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder=new ArrayList<>();
        helper(inorder,root);
        return balanced(inorder,0,inorder.size()-1);
    }
    static void helper(List<Integer> inorder,TreeNode root){
        if(root==null) return;
        helper(inorder,root.left);
        inorder.add(root.val);
        helper(inorder,root.right);
    }
    static TreeNode balanced(List<Integer> inorder,int l,int r){
        if(l>r) return null;
        int mid=l+(r-l)/2;
        TreeNode node=new TreeNode(inorder.get(mid));
        node.left=balanced(inorder,l,mid-1);
        node.right=balanced(inorder,mid+1,r);
        return node;
    }
}