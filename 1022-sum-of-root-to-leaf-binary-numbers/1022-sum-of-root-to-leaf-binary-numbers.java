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
    public int sumRootToLeaf(TreeNode root) {
        return func(root,"");
    }
    public static int func(TreeNode root,String str)
    {
            if(root==null)
                  return 0;
            if(root.left==root.right)
            {
                    return Integer.parseInt(str+root.val,2);
            }
            return func(root.left,str+root.val)+func(root.right,str+root.val);
    }
}