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
    int preIndex = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, 0, postorder.length - 1);
    }
    public TreeNode build(int[] pre, int[] post, int left, int right) {
        if (left > right || preIndex >= pre.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preIndex++]);
        if (left == right) {
            return root;
        }
        int i = left;
        while (i <= right && post[i] != pre[preIndex]) {
            i++;
        }
        if (i <= right) {
            root.left = build(pre, post, left, i);
            root.right = build(pre, post, i + 1, right - 1);
        }
        return root;
    }
}
