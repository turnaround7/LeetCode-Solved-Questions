class Solution {
    public int rob(int[] nums) {
       int arr[][]=new int[2][nums.length];
        arr[0][0]=nums[0];
        arr[1][0]=0;
        for(int i=1;i<nums.length;i++)
        {
            arr[0][i]=arr[1][i-1]+nums[i];
                arr[1][i]=Math.max(arr[0][i-1],arr[1][i-1]);
        }
        return Math.max(arr[0][nums.length-1],arr[1][nums.length-1]);
        
    }
}