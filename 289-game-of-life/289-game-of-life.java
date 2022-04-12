class Solution {
   
    public void gameOfLife(int[][] board) {
        int arr[][]=new int [2][board.length*board[0].length];
        int index=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(j<board[0].length-1)
                {
                    if(board[i][j+1]==1)
                        arr[0][index]++;
                    else
                        arr[1][index]++;
                }
                if(i<board.length-1&&j<board[0].length-1)
                {
                    if(board[i+1][j+1]==1)
                       arr[0][index]++;
                    else
                       arr[1][index]++;
                }
                if(i<board.length-1)
                {
                    if(board[i+1][j]==1)
                       arr[0][index]++;
                    else
                        arr[1][index]++;
                }
                if(i<board.length-1&&j>0)
                {
                    if(board[i+1][j-1]==1)
                        arr[0][index]++;
                    else
                        arr[1][index]++;
                }
                 if(j>0)
                {
                    if(board[i][j-1]==1)
                        arr[0][index]++;
                    else
                       arr[1][index]++;
                }
                if(i>0&&j>0)
                {
                    if(board[i-1][j-1]==1)
                        arr[0][index]++;
                    else
                        arr[1][index]++;
                }
             
                if(i>0)
                {
                    if(board[i-1][j]==1)
                        arr[0][index]++;
                    else
                       arr[1][index]++;
                }
                 if(i>0&&j<board[0].length-1)
                {
                    if(board[i-1][j+1]==1)
                        arr[0][index]++;
                    else
                        arr[1][index]++;
                }
                
                index++;
            }
        }
       
        index=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                int current=board[i][j];
                int live=arr[0][index];
                int dead=arr[1][index];
                if(current==0&&live==3)
                    board[i][j]=1;
                else
                {
                    if(live<2||live>3)
                        board[i][j]=0;
                        
                }
                index++;
            }
        }
    }
}