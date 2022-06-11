class Solution {
    public int minOperations(int[] nums, int xx) {
        
        
        int x=0;
        for(int t:nums)
            x+=t;
        
        if(x==xx)
            return nums.length;
        
        x-=xx;
        
        int l=0;
        int sum=0;
        int ans=-1;
        
        
        // System.out.println(x);
        for(int r=0; r<nums.length;r++)
        {
            sum+=nums[r];
            // System.out.println(l+"  "+r+"   "+sum);
            
            while(sum>=x && l<=r)
            {
                if(sum==x)
                    ans=Math.max(ans, r-l+1);
                // System.out.println("in"+ ans);
                sum-=nums[l++];
            }
        }
        
        if(ans==-1)
            return -1;
        return nums.length-ans;
        
    }
}