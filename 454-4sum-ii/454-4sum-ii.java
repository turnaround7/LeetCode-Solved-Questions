class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
       HashMap<Integer,Integer> first=new HashMap<>();
       HashMap<Integer,Integer> second=new HashMap<>();
        for(int i=0;i<nums1.length;i++)
        {  
            for(int j=0;j<nums1.length;j++)
            {
                int num1=nums1[i]+nums2[j];
                int num2=nums3[i]+nums4[j];
                if(first.containsKey(num1))
                first.put(num1,first.get(num1)+1);
                else
                first.put(num1,1);
                
                if(second.containsKey(num2))
                second.put(num2,second.get(num2)+1);
                else
                second.put(num2,1);
            }
        }
        int ans=0;
        for (Map.Entry mapElement : first.entrySet()) {
            int key = (int)mapElement.getKey();
            if(second.containsKey(0-key))
                ans+=second.get(0-key)*first.get(key);
        }
        //System.out.println(first+" "+second);
        return ans;
    }
}
// -1 0 0 1
// -1 1 2 0
//-1 1  (0,0,0,1)
// 0 0 (0,1,0,1)
// 0 0(1,0,0,1)
