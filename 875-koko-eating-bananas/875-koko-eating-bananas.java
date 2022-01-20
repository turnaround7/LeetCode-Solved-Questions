// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
        
//         int max=Integer.MIN_VALUE;
//         int min=Integer.MAX_VALUE;
//         int sum=0;
//         for(int i=0;i<piles.length;i++)
//         {
//             if(piles[i]>max)
//                 max=piles[i];
//             if(piles[i]<min)
//                 min=piles[i];
//             sum=sum+piles[i];
//         }
       
//         int hour=0;
//         while(min<=max)
//         {
//          // checking for individual min
//             hour=0;
//           for(int i: piles)
//           {
//               hour+=Math.ceil(i/min);
//           }
//              System.out.println(hour);
           
//             if(hour<=h)
//                 return min;
//             min++;
//         }
//         return -1;
//     }
// }
// // 11 7 6 3
// // 3
// /*
//  : (sum of all)
//  27/3
//  =9 
//  27/4=7
//  Max will be max number of pile 
//  ans min start will be min in the pile
//  */




class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1, end = maxArray(piles);
        if(h == piles.length)
            return end;
        int minimumBananas = 0;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(checkIfAllBananasFinished(mid, piles, h)) {
                minimumBananas = mid;
                end = mid - 1;            
            } else {
                start = mid + 1;
            }
        }
        return minimumBananas;
    }
    private int maxArray(int[] piles) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            if(piles[i] > max)
                max = piles[i];
        }
        return max;
    }
    private boolean checkIfAllBananasFinished(int minBanana, int[] piles, int h) {
        int sum = 0;
        for(int i = 0; i < piles.length; i++) {
            if(sum > h)
                break;
            sum += Math.ceil(((double)piles[i] / minBanana));
        }
        if(sum <= h)
            return true;
        return false;
    }
}