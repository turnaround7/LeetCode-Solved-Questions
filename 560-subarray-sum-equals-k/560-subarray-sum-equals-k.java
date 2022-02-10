class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int pre_sum=0;
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(0,1);
       for(int i=0;i<nums.length;i++){
           pre_sum+=nums[i];
           if(hm.containsKey(pre_sum-k)){
               count+=hm.get(pre_sum-k);
           }
           hm.put(pre_sum,hm.getOrDefault(pre_sum,0)+1);
       } 
        return count; 
    }
}