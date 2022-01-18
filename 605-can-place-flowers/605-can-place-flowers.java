class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0;i<flowerbed.length;i++)
        {
            int back=(i>0)?flowerbed[i-1]:0;
            int front=(i<flowerbed.length-1)?flowerbed[i+1]:0;
            if(flowerbed[i]==0&&back==0&&front==0)
            {
               n--;
                flowerbed[i]=1;
            } 
        }
        return (n<=0)?true:false;
    }
}