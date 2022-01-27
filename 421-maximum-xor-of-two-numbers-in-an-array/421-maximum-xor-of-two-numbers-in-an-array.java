// class Solution {
//     public static class Trie
//     {
//         public class Node
//         {
//             Node right,left;
//         }
//         Node root;
//         Trie()
//         {
//            root=new Node();
//         }
//         public  void insert(int val)
//         {
//             Node curr=root;
//             int mask=31;
//             while(mask>=0)
//             {
//                 int temp=1<<mask;
//                 int add=(val&temp)>0?1:0;
//                 if(add==1)
//                 {
//                     if(curr.left==null)
//                         curr.left=new Node();
//                     curr=curr.left;
//                 }
//                 else
//                 {
//                     if(curr.right==null)
//                         curr.right=new Node();
//                     curr=curr.right;
//                 }
//                 mask--;
//             }
            
//         }
//         public  int query(int val)
//         {
//             Node curr=root;
//             int mask=31;
//             int ans=0;
//             while(mask>=0)
//             {
//                 int temp=1<<mask;
//                 int add=(val&temp)>0?1:0;
//                 if(add==0)
//                 {
//                     if(curr.left!=null)
//                     {
//                         curr=curr.left;
//                     }
//                     else
//                         curr=curr.right;
//                     ans|=mask;
//                 }
//                 else
//                 {
//                     if(curr.right!=null)
//                     {
//                         curr=curr.right;
//                     }
//                     else
//                         curr=curr.left;
//                     ans|=mask;
//                 }
//                 mask--;
//             }
//             return ans;
            
//         }
//     }
   
//     public int findMaximumXOR(int[] nums) {
//         Trie trie=new Trie();
//         for(int i: nums)
//             trie.insert(i);
//         int max=0;
//         for(int n:nums)
//         {
//           // searching the max that we can form using n ;
//             int toFind=Integer.MAX_VALUE^n;
//             int found=trie.query(toFind);
//             System.out.println(found+" "+(25^n));
//             max=Math.max(max,(n^found));
//         }
        
//         return max;    
//     }
// }

class Solution {
     public class TrieNode{
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[2];
        }
    }
    
    public TrieNode root;
    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        
       
        for(int num : nums){
            insert(num);
        }
        
    
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            int temp = find(num);
            max = Math.max(temp, max);
        }
        return max;
    }
    
    public int find(int number){
        TrieNode current = root;
        int bitIdx = 31;
        int ans = 0;
        
        while(bitIdx >= 0){
            int mask = 1<<bitIdx;
            int currentBitValue = (mask&number) == 0? 0 : 1;
            int requiredBitValue = currentBitValue^1;
            
            TrieNode node = current;
    
            if(node.children[requiredBitValue] != null){
                ans += mask;
                current = node.children[requiredBitValue];
            }else{
               
                current = node.children[currentBitValue];
            }
            bitIdx--;
        }
        return ans;
    }
    
    public void insert(int number){
        TrieNode current = root;
        int bitIdx = 31;
        
        while(bitIdx >= 0){
            //find the bit
            int mask = 1<<bitIdx; 
            int bitValue = (mask&number) == 0? 0 : 1;
            
            TrieNode node = current.children[bitValue];
            if(node == null){
                node = new TrieNode();
                current.children[bitValue] = node;
            }
            current = node;
            bitIdx--;
        }
    }
}