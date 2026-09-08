/* Structure of Linked List Node
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}
*/

class Solution {
    public static void removeLoop(Node head) {

        Node slow = head;
        Node fast = head;

        // slow 1 step chalega
        // fast 2 step chalega
        // dono agar mil gaye -> loop hai

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // TC:
        // 1 -> 2 -> 3 -> 4 -> 5
        // slow aur fast move karenge
        //
        // slow=2, fast=3
        // slow=3, fast=5
        // slow=4, fast=4
        //
        // slow == fast
        // matlab loop mil gaya


        // loop nahi mila
        if (slow != fast) return;


        slow = head;
        // slow ko wapas head par le aaye
        //
        // slow=1
        // fast=4


        // agar loop head se hi start ho raha hai
        if (slow == fast) {

            while (fast.next != slow) {
                fast = fast.next;
            }

            // fast loop ke last node par hai
            // last node ka next head ko point kar raha hai
            // us next ko null kar do

            fast.next = null;
            return;
        }


        while (slow.next != fast.next) {

            slow = slow.next;
            fast = fast.next;

            // TC:
            // slow=1, fast=4
             // slow.next=2
            // fast.next=5
            // same nahi -> move
            //
        // slow=2, fast=5
            // slow.next=3
        // fast.next=3
            // same -> stop
        }


        // fast loop ke last node par hai
    // fast.next loop ke starting node ko point kar raha hai
        //
        // fast.next = 3
        // ise null kar do

        fast.next = null;

        // Final:
        // 1 -> 2 -> 3 -> 4 -> 5 -> null
    }
}

// Implement Algorithm: **Floyd’s Tortoise and Hare + Loop Removal Technique** 🔥