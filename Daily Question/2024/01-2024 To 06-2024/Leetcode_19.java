/*
 * 19. Remove Nth Node From End of List
    Given the head of a linked list, remove the nth node from the end of the list and return its head.

    Example 1:
    Input: head = [1,2,3,4,5], n = 2
    Output: [1,2,3,5]

    Example 2:
    Input: head = [1], n = 1
    Output: []

    Example 3:
    Input: head = [1,2], n = 1
    Output: [1]

    Constraints:
        The number of nodes in the list is sz.
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz
*/

public class Leetcode_19 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { 
            this.val = val; 
        }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) {
            head = null;
            return head;
        }
        ListNode ptr = head;
        int count = 0;
        while(ptr != null) {
            count++;
            ptr = ptr.next;
        }
        if(count == n) {
            head = head.next;
            return head;
        }
        ptr = head;
        for(int i = 0; i<count-n-1; i++) {
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        return head;
    }
    public static void main(String[] args) {
        
    }
}