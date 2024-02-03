class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode temp = dummy;

        while (temp.next != null) {
            temp = temp.next;
            count++;
        }

        temp = dummy;

        while (count >= k) {
            int nodes = k;
            ListNode tempNext = temp.next;
            ListNode prev = null;
            ListNode curr = temp.next;

            while (nodes-- > 0) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            temp.next = prev;
            tempNext.next = curr;
            temp = tempNext;
            count -= k;
        }

        return dummy.next;
    }
}
