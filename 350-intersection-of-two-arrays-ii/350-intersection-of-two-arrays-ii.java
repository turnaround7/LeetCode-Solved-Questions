class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i: nums1)
        {
            if(hm.containsKey(i))
            {
                int g=hm.get(i)+1;
                hm.put(i,g);
            }
            else
            {
                hm.put(i,1);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i: nums2)
        {
            if(hm.containsKey(i)&&hm.get(i)>0)
            {
                ans.add(i);
                hm.put(i,hm.get(i)-1);
            }
        }
        int a[]=new int[ans.size()]; int index=0;
        for(Integer i: ans)
        {
            a[index]=i;
            index++;
        }
        return a;
        
    }
}