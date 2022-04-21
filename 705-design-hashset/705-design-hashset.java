class MyHashSet {
    boolean arr[];
    public MyHashSet() {
         arr=new boolean [1000001];
    }
    
    public void add(int key) {
       //void add(key) Inserts the value key into the HashSet.
       arr[key]=true;
    }
    
    public void remove(int key) {
        arr[key]=false;
    }
    
    public boolean contains(int key) {
        return (arr[key]==true)?true:false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */