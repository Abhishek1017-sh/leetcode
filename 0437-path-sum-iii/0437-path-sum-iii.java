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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> prefix=new HashMap<>();
        prefix.put(0L,1);
        return dfs(root,0L,targetSum,prefix);
    }
    static int dfs(TreeNode root,long curr,int target,HashMap<Long,Integer> prefix){
        if(root==null) return 0;
        curr+=root.val;
        int paths=prefix.getOrDefault(curr-target,0);
        prefix.put(curr,prefix.getOrDefault(curr,0)+1);
        paths+=dfs(root.left,curr,target,prefix);
        paths+=dfs(root.right,curr,target,prefix);
        prefix.put(curr,prefix.get(curr)-1);
        return paths;
    }
}