class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // Shifting the array to the right
        for(int i=m-1;i>=0;i--)
            nums1[n+i]=nums1[i];
        int first=n;
        int second=0;
        int index=0;
      
        while(first<nums1.length||second<n)
        {
            int f1=(first<nums1.length)?nums1[first]:Integer.MAX_VALUE;
            int s1=(second<n)?nums2[second]:Integer.MAX_VALUE;
            if(f1>s1)
            {
                nums1[index]=s1;
                second++;
            }
            else
            {
                nums1[index]=f1;
                first++;
            }
            index++;
        }
        
    }
}