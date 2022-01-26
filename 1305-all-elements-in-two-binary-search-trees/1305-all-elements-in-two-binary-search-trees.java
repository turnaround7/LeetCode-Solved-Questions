/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static ArrayList<Integer> preorder(TreeNode root)
    {
        if(root==null)
            return new ArrayList<>();
        ArrayList<Integer> arr=preorder(root.left);
        
        arr.add(root.val);
        ArrayList<Integer> right=preorder(root.right);
        arr.addAll(right);
        return arr;
        
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> first=preorder(root1);
        ArrayList<Integer> second=preorder(root2);
       // System.out.println(first+" "+second);
        first.addAll(second);
        Collections.sort(first);
        return first;
    }
}