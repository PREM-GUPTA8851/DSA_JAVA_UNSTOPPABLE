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
        // ans = []

        if (root == null)
            return ans;
        // Tree empty -> []

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        // q = [3]

        while (!q.isEmpty()) {

            int size = q.size();
            // 1st while
            // size = 1

            List<Integer> level = new ArrayList<>();
            // level = []

            for (int i = 0; i < size; i++) {

                // i = 0

                TreeNode curr = q.poll();
                // curr = 3
                // q = []

                level.add(curr.val);
                // level = [3]

                if (curr.left != null)
                    q.offer(curr.left);
                // q = [9]

                if (curr.right != null)
                    q.offer(curr.right);
                // q = [9,20]
            }

            ans.add(level);
            // ans = [[3]]



            // 2nd while

            // q = [9,20]

            // size = 2

            // level = []

            // i = 0

            // curr = 9
            // q = [20]

            // level = [9]

            // 9.left = null
            // 9.right = null

            // q = [20]



            // i = 1

            // curr = 20
            // q = []

            // level = [9,20]

            // q.offer(15)
            // q = [15]

            // q.offer(7)
            // q = [15,7]

            // ans = [[3],[9,20]]



            // 3rd while

            // q = [15,7]

            // size = 2

            // level = []

            // i = 0

            // curr = 15
            // q = [7]

            // level = [15]

            // 15 ke children nahi



            // i = 1

            // curr = 7
            // q = []

            // level = [15,7]

            // 7 ke children nahi

            // ans = [[3],[9,20],[15,7]]
        }

        return ans;
    }
}