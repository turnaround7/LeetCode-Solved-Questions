class Solution {
    //T: O(nlogn)
    //S: O(1)
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[] a, int[] b) -> a[0]<b[0]?-1:1);
        int res = 0;
        int[] prev = points[0];
        for(int i=1;i<points.length;i++){
            if(points[i][0] <= prev[1]){
                prev[0] = Math.max(prev[0], points[i][0]);
                prev[1] = Math.min(prev[1], points[i][1]);
            }else{
                res++;
                prev = points[i];
            }
        }
        res++;
        return res;
    }
}