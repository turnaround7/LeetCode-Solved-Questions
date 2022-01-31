class Trie {
     Node root;
    public static class Node
    {
        Node arr[];
        boolean isEnd;
        Node()
        {
            arr =new Node[26];
            isEnd=false;
        }
    }

    public Trie() {
        root=new Node();
       
    }
    
    public void insert(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++)
        {
            char current=word.charAt(i);
            int index=current-'0'-49;
            if(temp.arr[index]==null)
                temp.arr[index]=new Node();
            temp=temp.arr[index];
        }
        temp.isEnd=true;
        
    }
    
    public boolean search(String word) {
        Node temp=root;
        for(int i=0;i<word.length();i++)
        {
            char current=word.charAt(i);
            int index=current-'0'-49;
            if(temp.arr[index]==null)
                return false;
            temp=temp.arr[index];
        }
       if(temp.isEnd==true)
           return true;
        return false;
        
    }
    
    public boolean startsWith(String prefix) {
        Node temp=root;
        for(int i=0;i<prefix.length();i++)
        {
            char current=prefix.charAt(i);
            int index=current-'0'-49;
            if(temp.arr[index]==null)
                return false;
            temp=temp.arr[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */