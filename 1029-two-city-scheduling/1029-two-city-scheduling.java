class Solution {
    public class object implements Comparable<object>
    {
        int index;
        int difference;
        public object(int index,int difference)
        {
            this.index=index;
            this.difference=difference;
        }
        public int compareTo(object other)
        {
            if(this.difference>=other.difference)
                return 1;
            else
                return -1;
        }
        
    }
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<object> pQueue= new PriorityQueue<object>();
        for(int i=0;i<costs.length;i++)
        {
            int diff=costs[i][1]-costs[i][0];
           // System.out.println(diff);
            pQueue.add(new object(i,diff));
       }
        //System.out.println(pQueue.peek().difference);
        // for the starting elements i need to take the costs[i][1];
        // else the part will be costs[i][0];
        
        int count=0;
        int ans=0;
        while(count<costs.length/2)
        {
            int index=pQueue.remove().index;
            ans+=costs[index][1];
            count++;
        }
        while(count<costs.length)
        {
            int index=pQueue.remove().index;
            ans+=costs[index][0];
            count++;
        }
        
        
        return ans;  
    }
}
// equal number of people in both the cities
