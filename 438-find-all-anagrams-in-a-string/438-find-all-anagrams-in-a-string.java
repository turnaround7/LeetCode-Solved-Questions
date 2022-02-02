class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if(s.length()<p.length())
            return ans;
        HashMap<Character,Integer> given=new HashMap<>();
        for(int i=0;i<p.length();i++)
        {
            char present=p.charAt(i);
            if(given.containsKey(present))
            {
                given.put(present,given.get(present)+1);
            }
            else
            {
                 given.put(present,1);
            }
        }
          HashMap<Character,Integer> temp=new HashMap<>();
        for(int i=0;i<p.length();i++)
        {
            char present=s.charAt(i);
            if(temp.containsKey(present))
            {
                temp.put(present,temp.get(present)+1);
            }
            else
            {
                 temp.put(present,1);
            }
        }
        int index=0;
        if(given.equals(temp))
            ans.add(index);
        index++;
        for(int i=p.length();i<s.length();i++)
        {
            char present=s.charAt(i);
            if(temp.containsKey(present))
            {
                temp.put(present,temp.get(present)+1);
            }
            else
            {
                 temp.put(present,1);
            }
            present=s.charAt(i-p.length());
            if(temp.get(present)>1)
            {
                temp.put(present,temp.get(present)-1);
            }
            else
            {
              temp.remove(present);
            }
             if(given.equals(temp))
            ans.add(index);
            index++;
        }
        return ans;
    }
}