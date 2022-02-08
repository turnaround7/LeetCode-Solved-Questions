class Solution {
    public int[] sortEvenOdd(int[] nums) {
        ArrayList<Integer> even=new ArrayList<>();
        ArrayList<Integer> odd=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
                even.add(nums[i]);
                else
                    odd.add(nums[i]);
        }
        Collections.sort(even);
        Collections.sort(odd);
        int index1=0;
        int index2=odd.size()-1;
        for(int i=0;i<nums.length;i++)
        {
            if(i%2==0)
            {
                nums[i]=even.get(index1);
                index1++;
            }
            else
            {
                nums[i]=odd.get(index2);
                index2--;
            }
            
        }
        return nums;
    }
}