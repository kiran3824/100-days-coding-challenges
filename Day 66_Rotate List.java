/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode temp = head;
        int n = 1;
        while (temp.next != null) {
            temp = temp.next;
            n++;
        }
        temp.next = head;

        k = k % n;
        int jump = n - k - 1;
        temp = head;
        while (jump > 0) {
            temp = temp.next;
            jump--;
        }
        ListNode returnHead = temp.next;
        temp.next = null;
        return returnHead;
    }
}