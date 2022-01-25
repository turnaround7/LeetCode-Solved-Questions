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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> arr=new ArrayList<>();
        int max=Integer.MIN_VALUE;
        while(!queue.isEmpty())
        {
            max=Integer.MIN_VALUE;
            Queue<TreeNode> temp=new LinkedList<>();
            while(!queue.isEmpty())
                  {
                      TreeNode t=queue.remove();
                      if(t.val>max)
                          max=t.val;
                     if(t.left!=null)
                         temp.add(t.left);
                if(t.right!=null)
                    temp.add(t.right);
                  }
            arr.add(max);
            queue=temp;
        }
        return arr;
            
    }
}