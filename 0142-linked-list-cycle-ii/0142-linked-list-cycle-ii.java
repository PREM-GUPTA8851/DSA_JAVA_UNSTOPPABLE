/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        // slow 1 step chalega
        // fast 2 step chalega

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            // Example:
            // 3 → 2 → 0 → -4
            //          ↑     ↓
            //          ← ← ←

            // slow aur fast ek point par mil gaye
            // matlab cycle present hai

            if (slow == fast) {

                slow = head;
                // ek pointer head par wapas

                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow;
                // yahi cycle ka starting node hai
            }
        }

        return null;
        // cycle nahi hai
    }
}