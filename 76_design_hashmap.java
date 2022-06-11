class MyHashMap {

    private Node[] buckets;
    private int size;
    private static double LOAD_FACTOR = 0.75;
    
    
    public MyHashMap() {
        buckets = new Node[16];
        size = 0;
    }
    
    public void put(int key, int value) {
        int hash = getHash(key);
        Node head = buckets[hash];
        
        while (head != null && head.key != key) {
            head = head.next;
        }
        
        if (head != null) {
            head.value = value;
        } else {
            Node new_node = new Node(key, value);
            new_node.next = buckets[hash];
            buckets[hash] = new_node;
            
            size = size + 1;
        }
        
        if (size >= buckets.length * LOAD_FACTOR)
        {
            expand();
        }
    }
    
    public int get(int key) {
        int hash = getHash(key);
        Node head = buckets[hash];
        
        while (head != null && head.key != key) {
            head = head.next;
        }
        
        return (head == null)? -1 : head.value;
    }
    
    public void remove(int key) {
        int hash = getHash(key);
        Node head = buckets[hash];
        
        Node dummy = new Node(0,0), curr = dummy;
        dummy.next = head;
        
        while (curr.next != null && curr.next.key != key)
        {
            curr = curr.next;
        }
        
        if (curr.next != null)
        {
            curr.next = curr.next.next;
            size = size - 1;
        }
        
        buckets[hash] = dummy.next;
    }
    
    private int getHash (int key) {
        return key % buckets.length;
    }
    
    private void expand()
    {
        Node[] old_buckets = buckets;
        Node[] new_buckets = new Node[buckets.length * 2];
        buckets = new_buckets;
        
        for (Node header : old_buckets)
        {
            while (header != null)
            {
                put(header.key, header.value);
                header = header.next;
            }
        }
    }
    
    class Node {
        int key, value;
        Node next;
        
        Node (int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */