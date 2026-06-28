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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        gainFromSubtree(root);
        return maxSum;
    }
    public int gainFromSubtree(TreeNode root){
        if (root == null){
            return 0;
        }
        int gain_from_left = Math.max(gainFromSubtree(root.left), 0);
        int gain_from_right = Math.max(gainFromSubtree(root.right), 0);
        maxSum = Math.max(maxSum, gain_from_left + gain_from_right + root.val);
        return Math.max(gain_from_left + root.val, gain_from_right + root.val);
    }
}