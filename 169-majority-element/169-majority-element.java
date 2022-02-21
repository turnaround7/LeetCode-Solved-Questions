class Solution {
    public int majorityElement(int[] nums) {
       
        int num=-1;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
            {
                num=nums[i];
                count++;
            }
            else if(num==nums[i])
            {
               count++; 
            }
            else
                count--;
            
            
        }
        // rechecking  the number 
        count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==num)
                count++;
        }
        if(count> (nums.length/2))
         return num;
        else 
            return -1;
        }
}