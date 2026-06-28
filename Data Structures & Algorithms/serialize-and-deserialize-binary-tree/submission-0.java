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

public class Codec {
    
    
    public static final String delimiter = ",";
    public static final String nullValue = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeTree(root, sb);
        return sb.toString();
    }
    public void serializeTree(TreeNode root, StringBuilder sb){
        if (root == null){
            sb.append(nullValue + delimiter);
            return;
        }
        sb.append(String.valueOf(root.val) + delimiter);
        serializeTree(root.left, sb);
        serializeTree(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(delimiter);
        Queue<String> nodes = new LinkedList<>();
        for (String node: parts){
            nodes.add(node);
        }
        TreeNode root = deserializer(nodes);
        return root;
    }
    public TreeNode deserializer(Queue<String> nodes){
        String node = nodes.remove();
        if (node.equals(nullValue)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left= deserializer(nodes);
        root.right = deserializer(nodes);
        return root;

    }
}
