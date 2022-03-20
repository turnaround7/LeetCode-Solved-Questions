class FreqStack {
  HashMap<Integer,ArrayList<Integer>> hm;
HashMap<Integer,Integer> hf;
    int maxF;
    public FreqStack() {
        hf=new HashMap<>();
        hm=new HashMap<>();
        maxF=0;
    }
    
    public void push(int val) {
        if(hf.containsKey(val))
            hf.put(val,hf.get(val)+1);
        else
            hf.put(val,1);
        int current=hf.get(val);
        if(!hm.containsKey(current))
            hm.put(current,new ArrayList<>());
           hm.get(current).add(val);
        if(current>maxF)
            maxF=current;
        // System.out.println(hm);
        // System.out.println(hf);
        // System.out.println("_______________");
    }
    
    public int pop() {
        
        int ans=hm.get(maxF).get(hm.get(maxF).size()-1);
        hm.get(maxF).remove(hm.get(maxF).size()-1);
        if(hm.get(maxF).size()==0)
            maxF--;
        hf.put(ans,hf.get(ans)-1);
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */