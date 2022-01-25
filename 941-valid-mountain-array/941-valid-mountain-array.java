class Solution {
    public boolean validMountainArray(int[] arr) {
       int big=arr[0];
        boolean bool=true;
        int index=0;
        // for strictly decreasing and strictly decreasing
        if(arr.length<3||arr[1]<=arr[0]||arr[arr.length-1]>=arr[arr.length-2])
            return false;
        
        while(index<arr.length-1)
        {
            if(arr[index]>=arr[index+1])
                break;
            index++;
        }
        while(index<arr.length-1)
        {
             if(arr[index]<=arr[index+1])
                return false;
            index++;
        }
        return true;
    }
}

/*
0 1 2 3
1 2 3 4
index<3: index--> 0 , 1 , 2
index
0.    1>2
1.    2>3
2.    3>4


*/
// 1 2 3 4 
