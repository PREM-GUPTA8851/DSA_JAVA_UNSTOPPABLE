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
        // Final answer store karega
        if (root == null)
            return ans;
        // Tree empty hai to []

        Queue<TreeNode> q = new LinkedList<>();
        // BFS ke liye queue

        q.offer(root);
        // Root ko queue me daal diya

        while (!q.isEmpty()) {

            int size = q.size();
            // Current level me jitne nodes hain

            List<Integer> level = new ArrayList<>();
            // Current level ke nodes store honge

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                // Queue ke front node ko nikalo

                level.add(curr.val);
                // Uski value current level me add karo

                if (curr.left != null)
                    q.offer(curr.left);
                // Left child ko queue me daalo

                if (curr.right != null)
                    q.offer(curr.right);
                // Right child ko queue me daalo
            }

            ans.add(level);
            // Current level complete, answer me add
        }

        return ans;
    }
}