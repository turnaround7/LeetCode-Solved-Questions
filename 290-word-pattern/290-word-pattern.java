class Solution {
    public boolean wordPattern(String pattern, String s) {
      String arr[]=s.split(" ");
       
        StringBuilder sb=new StringBuilder();
        HashMap<Character,String> hm=new HashMap<>();
        Set<String> set=new HashSet<>();
        for(int i=0;i<pattern.length()&&i<arr.length;i++)
        {
            char c=pattern.charAt(i);
            if(hm.containsKey(c))
            {
               
             if(arr[i].equals(hm.get(c))==false)
                return false; 
             }
            else
            {
                if(set.contains(arr[i]))
                    return false;
                else
               hm.put(c,arr[i]); 
                set.add(arr[i]);
                
            }
            sb.append(c);
           // System.out.println(hm+" "+sb);
        }
        if(sb.toString().equals(pattern)&&sb.length()==arr.length)
            return true;
        return false;
    }
}