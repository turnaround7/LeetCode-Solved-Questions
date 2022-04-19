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
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> preOrder=preorder(root);
        ArrayList<Integer> copy=new ArrayList<>();
        for(Integer k: preOrder)
            copy.add(k);
        Collections.sort(copy);
        int i=0;
        int toChange=-1,newVal=-1;
        boolean b=false;
          for(Integer k: preOrder)
          {
              if(k!=copy.get(i))
              {
                  toChange=k;
                  newVal=copy.get(i);
                  b=true;
                  break;
              }
              i++;
          }
        if(b==true)
        {
         //   System.out.println(toChange+" "+newVal);
           preorder(root,toChange,newVal); 
            
        }
        else
            return ;
        
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
    public void preorder(TreeNode root,int val1,int val2)
    {
      boolean val1Found=false,val2Found=false;
       // int count=0;
      Queue<TreeNode> q=new LinkedList<>();
      q.add(root);
        while(!q.isEmpty())
        {
            int count=0;
            TreeNode current=q.remove();
            if(current.val==val1&&val1Found==false)
            {
                current.val=val2;
                val1Found=true;
                count=1;
            }
            if(count==0&&current.val==val2&&val2Found==false)
            {
                current.val=val1;
                val2Found=true;
                
            }
            if(current.left!=null)
                q.add(current.left);
            if(current.right!=null)
                q.add(current.right);
            
        }
    }
}