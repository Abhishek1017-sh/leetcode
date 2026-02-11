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
    public int maxProduct(TreeNode root) {
        long mod=1000000007;
        long total=sumtree(root);
        long[] max=new long[1];
        dfs(root,max,total);
        return (int)(max[0]%mod);
    }
    static long sumtree(TreeNode node){
        if(node==null){
            return 0;
        }
        return node.val+sumtree(node.left)+sumtree(node.right);
    }
    static long dfs(TreeNode node,long[] max,long total){
        if(node==null) return 0;
        long left=dfs(node.left,max,total);
        long right=dfs(node.right,max,total);
        long sum=left+right+node.val;
        long product=sum*(total-sum);
        max[0]=Math.max(max[0],product);
        return sum;
    }
}