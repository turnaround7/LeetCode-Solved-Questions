class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
       HashMap<Integer,Integer> first=new HashMap<>();
      
        for(int i=0;i<nums1.length;i++)
        {  
            for(int j=0;j<nums1.length;j++)
            {
                int num1=nums1[i]+nums2[j];
                
                if(first.containsKey(num1))
                first.put(num1,first.get(num1)+1);
                else
                first.put(num1,1);
                
               
            }
        }
        int ans=0;
         for(int i=0;i<nums1.length;i++)
        {  
            for(int j=0;j<nums1.length;j++)
            {
                int num1=nums3[i]+nums4[j];
                if(first.containsKey(0-num1))
                    ans+=first.get(0-num1);
            }
         }
        
        return ans;
    }
}
// -1 0 0 1
// -1 1 2 0
//-1 1  (0,0,0,1)
// 0 0 (0,1,0,1)
// 0 0(1,0,0,1)
