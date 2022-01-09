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
        // right-root
        // root-left
    public int getMinimumDifference(TreeNode root) {
            ArrayList<Integer> arr=traversal(root);
             int min=Integer.MAX_VALUE;
            for(int i=1;i<arr.size();i++)
            {
                    min=Math.min(min,arr.get(i)-arr.get(i-1));
            }
            return min;
    }
        public static ArrayList<Integer> traversal(TreeNode root)
        {
                if(root==null)
                        return new ArrayList<>();
                ArrayList<Integer> a=new ArrayList<>();
                a=traversal(root.left);
                a.add(root.val);
                ArrayList<Integer> b=traversal(root.right);
                for(Integer i: b)
                        a.add(i);
                return a;
        }
}
