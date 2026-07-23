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

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        // Agar tree empty hai
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();

        // Root ko queue me daal do
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size();          // Current level me kitne nodes hain

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll(); // Front node nikalo

                level.add(curr.val);      // Answer me add karo

                // Left child agar hai to queue me daalo
                if (curr.left != null) {
                    q.offer(curr.left);
                }

                // Right child agar hai to queue me daalo
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }

            // Pura level complete ho gaya
            ans.add(level);
        }

        return ans;
    }
}