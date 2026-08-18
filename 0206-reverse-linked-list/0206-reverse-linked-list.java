class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        // prev = null

        ListNode current = head;
        // current = head

        while (current != null) {

            ListNode nextNode = current.next;
            // next node ko pehle store kiya
            // kyunki current.next reverse hone wala hai

            current.next = prev;
            // current ka link reverse kiya

            prev = current;
            // prev ko current node par le gaye

            current = nextNode;
            // current ko next node par move kiya
        }

        return prev;
        // prev hi reversed linked list ka new head hai
    }
}