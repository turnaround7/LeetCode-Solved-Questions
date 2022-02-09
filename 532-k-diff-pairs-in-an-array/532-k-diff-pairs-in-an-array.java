class Solution {
    public int findPairs(int[] nums, int k) {
        int ans=0;
    HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i: nums)
        {
            if(hm.containsKey(i))
                hm.put(i,hm.get(i)+1);
            else
                hm.put(i,1);
        }
        //  chec kfor num+1 and num-1 existince 
        // if it does then sub the num 
        // check if the other is >=1 and if yes increment the count
        //after that put num,0;
        
        
        // num1=+k+num2
        //num1=-k+num2
      //  System.out.println(hm);
         for (Map.Entry mapElement : hm.entrySet()) {
            int  key = (int)mapElement.getKey();
            int value=(int)mapElement.getValue();
                 if(k==0)
                {
                    if(value>=2)
                        ans++;
                }
              else
                {
                  if(value>0&&hm.containsKey(k+key)&&hm.get(k+key)>0)
                  ans++; 
                 if(value>0&&hm.containsKey((-1*k)+key)&&hm.get((-1*k)+key)>0)
                  ans++;  
                }
                hm.put(key,0);
               //System.out.println(ans+" "+ hm);
                
            }
        return ans;
    }
}