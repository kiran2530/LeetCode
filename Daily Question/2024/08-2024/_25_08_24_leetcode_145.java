/*
 *  145. Binary Tree Postorder Traversal
        Given the root of a binary tree, return the postorder traversal of its nodes' values.

    Example 1:
        Input: root = [1,null,2,3]
        Output: [3,2,1]
        
    Example 2:
        Input: root = []
        Output: []
        
    Example 3:
        Input: root = [1]
        Output: [1]
        
    Constraints:
        The number of the nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100
 */

import java.util.ArrayList;
import java.util.List;

public class _25_08_24_leetcode_145 {

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

    static TreeNode root;
    public static TreeNode buildTree(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -101) {
            return null;
        }

        // Create a new TreeNode with the current index's value
        TreeNode node = new _25_08_24_leetcode_145().new TreeNode(arr[index]);

        // Recursively create the left and right children
        node.left = buildTree(arr, 2 * index + 1);  // Left child index: 2 * index + 1
        node.right = buildTree(arr, 2 * index + 2); // Right child index: 2 * index + 2

        return node;
    }

    public static void helper(TreeNode node, List<Integer> ans) {
        if(node != null) {
            helper(node.left, ans);
            helper(node.right, ans);
            ans.add(node.val);
        }
    }
    
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        helper(root, ans);

        return ans;
    }

    public static void main(String[] args) {
        // null represent as -101
        int[] arr = {1,-101,2,3};
        root = buildTree(arr, 0);

        List<Integer> list = new ArrayList<>();

        list = postorderTraversal(root);
        System.out.println(list);
    }
}