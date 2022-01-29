class Solution {
    public int[] nextSmallerRight(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                res[st.pop()]=i;
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()]=arr.length;
        }
        return res;
    }
    public int[] nextSmallerLeft(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()>0 && arr[st.peek()]>arr[i]){
                res[st.pop()]=i;
            }
            st.push(i);
        }
        while(st.size()>0){
            res[st.pop()]=-1;
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int[] nsr=nextSmallerRight(heights);
        int[] nsl=nextSmallerLeft(heights);
        int max=0;
        for(int i=0;i<heights.length;i++){
            max=Math.max(max,(nsr[i]-nsl[i]-1)*heights[i]);
        }
        return max;
    }
}