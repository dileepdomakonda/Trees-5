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
// TC : O(n)
// SC : O(h)
// Method - 2 : Recursion
class Solution {
    TreeNode first = null, second = null, prev = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        
        helper(root);
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    
    private void helper(TreeNode root) {
        if(root == null) return;
        
        helper(root.left);
        if(prev != null && prev.val >= root.val) {
            if(first == null) {
                first = prev;
                second = root;
            }
            second = root;
        }
        prev = root;
        helper(root.right);
    }
}
