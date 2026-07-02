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
    int count = 0;
    public int goodNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root, Integer.MIN_VALUE);
        return count;
    }
    private void dfs(TreeNode root, int maxVal){
        if (root == null){
            return;
        }
        if (root.val >= maxVal){
            count ++;
            maxVal = root.val;

        }
        dfs(root.left, maxVal);
        dfs(root.right, maxVal);
    }
}
