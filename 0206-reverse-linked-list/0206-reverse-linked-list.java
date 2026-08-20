/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // ek node lo jo null ko point kre
        ListNode prev = null;

        // aur ek node lo jo current node ko point kre;
        ListNode current = head;

        while(current != null){
            
            ListNode nextNode = current.next;
            // pehle current k baad wala ko prev m kr do
            current.next = prev;

            prev = current;
            
            current = nextNode;
        }
        return prev;
    }
}