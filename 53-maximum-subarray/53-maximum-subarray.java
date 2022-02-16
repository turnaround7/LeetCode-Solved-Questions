class Solution {
    public int maxSubArray(int[] nums) {
        
        int current=nums[0];
        int ans=current;
        for(int i=1;i<nums.length;i++)
        {
            int num1=nums[i];
            int num2=current+num1;
            current=(num2>num1)?num2:num1;
            ans=(current>ans)?current:ans;
        }
        return ans;
        
        
    }
}
/*
-2
(-2+1)||(1) ==1
(-3+1)||(-3+1) ==-2
(4+-2)||(4)==4
(-1+4)||(-1) ==3
3+2 || 2 ==5

*/