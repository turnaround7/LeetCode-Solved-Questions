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
    public int kthSmallest(TreeNode root, int k) {
        // traversal using preorder 
       int count=0;
        ArrayList<Integer> arr=preorder(root);
        int ans=0;
        while(count<k)
        {
            ans=arr.get(count);
            count++;
        }
        return ans;
        
    }
    public ArrayList<Integer> preorder(TreeNode root)
    {
       if(root==null)
           return new ArrayList<>();
        ArrayList<Integer> ret=preorder(root.left);
        ret.add(root.val);
        ArrayList<Integer> ret1=preorder(root.right);
        for(Integer k: ret1)
            ret.add(k);
        return ret;
    }
}