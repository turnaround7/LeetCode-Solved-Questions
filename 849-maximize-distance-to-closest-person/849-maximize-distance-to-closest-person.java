class Solution {
    public int maxDistToClosest(int[] seats) {
        int l=seats.length, where=0, ans=0, first=1;
        
        for(int i=0 ; i<l ; i++){
			// 1 in the right
            if(first == 1 && seats[i] == 1){
                first=0;
                ans=Math.max(ans, i-where);
                where=i;
                continue;    
            }
            
			// between 1s
            if(seats[i] == 1){
                ans=Math.max(ans, (i-where)/2);
                where=i;
            }
        }
        
		// 1 in the left
        if(seats[l-1] == 0){
            
            ans=Math.max(ans, l-1-where);
        }
        
        return ans;
    }
}