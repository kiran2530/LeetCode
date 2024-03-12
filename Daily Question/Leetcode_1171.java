/*
 * 1171. Remove Zero Sum Consecutive Nodes from Linked List
    Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
    After doing so, return the head of the final linked list.  You may return any such answer.
    (Note that in the examples below, all sequences are serializations of ListNode objects.)

    Example 1:
    Input: head = [1,2,-3,3,1]
    Output: [3,1]
    Note: The answer [1,2,1] would also be accepted.

    Example 2:
    Input: head = [1,2,3,-3,4]
    Output: [1,2,4]

    Example 3:
    Input: head = [1,2,3,-3,-2]
    Output: [1]
    
    Constraints:
    The given linked list will contain between 1 and 1000 nodes.
    Each node in the linked list has -1000 <= node.val <= 1000.
*/
public class Leetcode_1171 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode head = null, tail = null;
    public void addNode(int val) {
        ListNode newNode = new ListNode(val);
        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void diplay(ListNode newNode) {
        ListNode node = newNode;
        if(head == null) {
            System.out.println("list empty...");
            return;
        }

        while (node != null) {
            System.out.print(node.val +  " ");
            node = node.next;            
        }
    }
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode front = new ListNode(0, head);
        ListNode start = front;
        while (start != null) {
            int sum = 0;
            ListNode end = start.next;

            while (end != null) {
                sum += end.val;
                if(sum == 0) {
                    start.next = end.next;
                }
                end = end.next;
            }
            start = start.next;
        }
        return front.next;
    }
    public ListNode getNode() {
        return head;
    }
    public static void main(String[] args) {
        Leetcode_1171 node = new Leetcode_1171();
        node.addNode(1);
        node.addNode(2);
        node.addNode(3);
        node.addNode(-3);
        node.addNode(-2);

        ListNode head = node.getNode();
        ListNode newNode = node.removeZeroSumSublists(head);
        node.diplay(newNode);
    }
}
