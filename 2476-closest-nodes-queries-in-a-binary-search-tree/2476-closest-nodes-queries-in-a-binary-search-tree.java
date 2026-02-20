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
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> inorder=new ArrayList<>();
        inordertra(inorder,root);
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<queries.size();i++){
            arr.add(helper(inorder,queries.get(i)));
        }
        return arr;
    }
    static void inordertra(List<Integer> inorder,TreeNode root){
        if(root==null) return;
        inordertra(inorder,root.left);
        inorder.add(root.val);
        inordertra(inorder,root.right);
    }
    static List<Integer> helper(List<Integer> arr,int i){
        int l=0;
        int r=arr.size()-1;
        int f=-1;
        int c=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr.get(mid)==i){
                f=c=arr.get(mid);
                break;
            }
            else if(arr.get(mid)>i){
                c=arr.get(mid);
                r=mid-1;
            }
            else{
                f=arr.get(mid);
                l=mid+1;
            }
        }
        return Arrays.asList(f,c);
    }
}