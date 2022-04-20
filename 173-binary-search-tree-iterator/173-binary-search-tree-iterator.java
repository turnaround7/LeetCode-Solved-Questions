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
class BSTIterator {
   TreeNode root;
    ArrayList<Integer> pre;
    int current=0;
    public BSTIterator(TreeNode root) {
        this.root=root;
        pre=preorder(root);
    }
    public ArrayList<Integer> preorder(TreeNode root)
    {
        if(root==null)
            return new ArrayList<>();
        ArrayList<Integer> a=preorder(root.left);
        a.add(root.val);
        ArrayList<Integer> b=preorder(root.right);
        for(Integer gg: b)
            a.add(gg);
        return a;
    }
    public int next() {
       
         if(current<pre.size())
         {
             int ans= pre.get(current);
             current++;
             return ans;
         }             
        return -1;
    }
    
    public boolean hasNext() {
       if(current<pre.size())
         {
           return true;
       }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */