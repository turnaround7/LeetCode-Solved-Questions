
/*
class Solution {
    public boolean isRobotBounded(String instructions) {
     
            int x=0;
            int y=0;
            char move='U';
          
            //U--move +X
            //R--move +Y
            //L--move -X
            //D--move -Y
            
            // signifying its straight 
            
              for(int i=0;i<instructions.length();i++)
            {
                    char c=instructions.charAt(i);
                    if(c=='G')
                    {
                            if(move=='U')
                                    y++;
                            else if(move=='D')
                                    y--;
                            else if(move=='R')
                                    x++;
                            else 
                                    x--;
                    }
                    if(c=='L')
                    {
                        if(move=='U')
                                    move='L';
                            else if(move=='D')
                                    move='R';
                            else if(move=='R')
                                    move='U';
                            else 
                                    move='D';    
                    }
                    if(c=='R')
                    {
                         if(move=='U')
                                    move='R';
                            else if(move=='D')
                                    move='L';
                            else if(move=='R')
                                    move='D';
                            else 
                                    move='U';     
                    }
                   
                            
                          
              }
                    System.out.println("x="+x+"y="+y);
            
                    if(x==0&&y==0)
                    return true;      
           
            
           
                    return false;
    }
}
*/

class Solution {
    public boolean isRobotBounded(String instructions) {
        int dir[][] = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        int i = 0;
        int x = 0;
        int y = 0;
       
        for(int s = 0; s < instructions.length(); s++){
            if(instructions.charAt(s) == 'L'){
                i = (i + 1) % 4;
            }
            else if(instructions.charAt(s) == 'R'){
                i = (i + 3) % 4;
            }
            else{
                x = x + dir[i][0];
                y = y + dir[i][1];
            }
        }
        return x == 0 && y == 0 || i != 0;
    }
}