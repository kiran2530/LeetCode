/*
    Given the head of a singly linked list, return the middle node of the linked list.
    If there are two middle nodes, return the second middle node.

    Example 1:
    Input: head = [1,2,3,4,5]
    Output: [3,4,5]
    Explanation: The middle node of the list is node 3.

    Example 2:
    Input: head = [1,2,3,4,5,6]
    Output: [4,5,6]
    Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
    
    Constraints:
    The number of nodes in the list is in the range [1, 100].
    1 <= Node.val <= 100
*/
public class Leetcode_876 {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        public ListNode(int val) { 
            this.val = val; 
        }
        ListNode(int val, ListNode next) { 
            this.val = val; 
            this.next = next; 
        }
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

    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode ptr1,midNode;
        if(head.next == null)
            return head;
        if(head.next.next == null)
            return head.next;
        ptr1 = head;
        midNode = head;
        while (ptr1.next != null) {
            count++;
             if(count % 2 == 0)
                midNode = midNode.next;
            ptr1 = ptr1.next;
        }
        if(count % 2 != 0)
            return midNode.next;
        return midNode;
    }
    public ListNode getNode() {
        return head;
    }
    public static void main(String[] args) {
        Leetcode_876 node = new Leetcode_876();
        node.addNode(1);
        node.addNode(2);
        node.addNode(3);
        node.addNode(4);
        node.addNode(5);

        ListNode head = node.getNode();
        System.out.print(" Full List : ");
        node.diplay(head);
        System.out.println();
        ListNode midNode = node.middleNode(head);
        System.out.print(" Mid Node : ");
        node.diplay(midNode);
    }
}