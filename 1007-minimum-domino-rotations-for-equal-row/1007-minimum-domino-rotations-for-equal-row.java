class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int common1=tops[0];
        int common2=bottoms[0];
        for(int i=1;i<tops.length;i++)
        {
            if(common1!=tops[i]&&common1!=bottoms[i])
            {
                common1=-1;
            }
            if(common2!=tops[i]&&common2!=bottoms[i])
            {
                common2=-1;
            }
             if(common1==-1&&common2==-1)
            return -1;
        }
        
        int up=0;
        int down=0;
        int first=Integer.MAX_VALUE;
        int second=Integer.MAX_VALUE;
        if(common1!=-1)
        {
            for(int i=0;i<tops.length;i++)
            {
                if(tops[i]==common1)
                    up++;
                if(bottoms[i]==common1)
                    down++;
            }
                first=(up>=down)?tops.length-up:tops.length-down;
        }
        if(common2!=-1)
        {
            up=0;down=0;
         for(int i=0;i<tops.length;i++)
            {
                if(tops[i]==common2)
                    up++;
                if(bottoms[i]==common2)
                    down++;
            }
                second=(up>=down)?tops.length-up:tops.length-down;   
        }
        return Math.min(first,second);
        
       
    }
}