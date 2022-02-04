class Solution {
    public int findMaxLength(int[] nums) {
        int sum=0;
        int length=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
                sum+=1;
            else
                sum+=-1;
            
            if(sum==0)
                length=i+1;
            else if(hm.containsKey(sum))
            {
                int temp=i-hm.get(sum);
                length=(temp>length)?temp:length;
            }
            else
                hm.put(sum,i);
           // System.out.println(sum+" "+length);
        }
        
        return length;
    }
    
}
/*
hashmap containg 0 and 1 and there count;

[0,0,1,0,0,0,1,1]
-1 -2 -1 -2 -3 -2 -1 

 */