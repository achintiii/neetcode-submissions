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
    int index = 0;
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder: NLR
        //inorder LNR
        // loop through preorder, find index in inorder, keep dividing
        
        for (int i = 0; i < inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1);

    }
    private TreeNode dfs(int[] preorder, int l, int r){
        if (l > r){
            return null;
        }
        int rootVal = preorder[index ++];
        TreeNode root = new TreeNode(rootVal);
        int mid = inOrderMap.get(root.val);
        root.left = dfs(preorder, l, mid - 1);
        root.right = dfs(preorder, mid + 1, r);
        return root;
    }
}
