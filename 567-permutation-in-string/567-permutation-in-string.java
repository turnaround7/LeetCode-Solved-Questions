class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s1.length();i++)
        {
            char ch=s1.charAt(i);
            if(hm.containsKey(ch))
                hm.put(ch,hm.get(ch)+1);
            else
                 hm.put(ch,1);
        }
         HashMap<Character,Integer> hm2=new HashMap<>();
        for(int i=0;i<s1.length();i++)
        {
            char ch=s2.charAt(i);
            if(hm2.containsKey(ch))
                hm2.put(ch,hm2.get(ch)+1);
            else
                 hm2.put(ch,1);
        }
        int past=0;
         
          for(int i=s1.length();i<s2.length();i++)
          {
             
              if(hm2.equals(hm))
                  return true;
              int val=hm2.get(s2.charAt(past));
              if(val>1)
                  hm2.put(s2.charAt(past),hm2.get(s2.charAt(past))-1);
              else
                  hm2.remove(s2.charAt(past));
              
            char ch=s2.charAt(i);
            if(hm2.containsKey(ch))
                hm2.put(ch,hm2.get(ch)+1);
            else
                 hm2.put(ch,1);
              
              past++;
          }
         if(hm2.equals(hm))
                  return true;
        return false;
    }
}