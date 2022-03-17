class Solution {
    public int scoreOfParentheses(String s) {
        // simply count the number of ) brackets
    Stack<Integer> stack=new Stack<>();
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            char now=s.charAt(i);
            if(now=='(')
            stack.push(-1);
            else 
           {
            ans=0;
            while(stack.peek()!=-1) 
            {
                ans+=stack.pop();
            }
                stack.pop();
                if(ans==0)
                    stack.push(1);
                else
                    stack.push(2*ans);
           }
      }
        int a=0;
        while(!stack.isEmpty())
            a+=stack.pop();
      return a; 
    }
}