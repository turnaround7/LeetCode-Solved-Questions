class Solution {
    public void rotate(int[] nums, int k) {
         k=k%nums.length;
        if(k==0)
            return;
        Stack<Integer> stack=new Stack<>();
        for(int i=nums.length-1;i>=nums.length-k;i--)
        {
            stack.push(nums[i]);
        }
        
        for(int i=nums.length-k-1;i>=0;i--)
        {
            nums[i+k]=nums[i];
        }
        for(int i=0;i<k;i++)
        {
            nums[i]=stack.pop();
        }
        
        return;
        
    }
}