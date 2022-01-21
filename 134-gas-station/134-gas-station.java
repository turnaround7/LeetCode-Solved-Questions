/*
 0+1
 1-3+2=0 < abort 1
 
 0+2
 2-4+3=1 
 1-5+3=-1 abort 
 
 3+0
 3-5+4=2
 2+5-1=6
 6-2+1=5
 5-3+2=4
 4-4+2=2
 
 
 
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, n = gas.length;
        for(int i=0;i<n;i++) {
            sum += gas[i]-cost[i];
        }
        if(sum < 0) return -1;
		
        int gasInTank = 0, start = 0;
        for(int i=0;i<n;i++) {
            gasInTank += gas[i]-cost[i];
            // if we are not able to reach next station from i, 
            if(gasInTank < 0) {
                start = i+1;
                gasInTank = 0;
            }
        }
        
        return gasInTank >= 0 ? start : -1; // we can as well just return "start" as we know circular route is possible
    }

}