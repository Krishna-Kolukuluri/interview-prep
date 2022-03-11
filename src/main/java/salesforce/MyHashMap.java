package salesforce;

class Node{
    Node(){};
    public int key=-1;
    public int value=-1;
    public Node next=null;
}

public class MyHashMap {

//Linked List o(1)
    Node[] map = new Node[227];
    public MyHashMap() {
        for(int i=0;i<map.length;i++){
            map[i] = null;
        }
    }
    
    public void put(int key, int value) {
        int hashCode  =  getHash(key);
        Node currNode= map[hashCode];
        Node prevNode = null;
        if(currNode==null){
            map[hashCode] = new Node();
            map[hashCode].key = key;
            map[hashCode].value = value;
            return;
        }        
        while(currNode!=null){            
            if(currNode.key==key){
                currNode.value = value;
                return;
            }
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = new Node();
        prevNode.next.key = key;
        prevNode.next.value = value;
        return;
    }

    public int get(int key) {
        int hashCode = getHash(key);
        Node currNode= map[hashCode];
        Node prevNode = null;     

        while(currNode!=null){
            if(currNode.key==key){
                return currNode.value;
            } 
            prevNode = currNode;
            currNode = currNode.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashCode =  getHash(key);
        
        Node currNode = map[hashCode];
        Node prevNode = null;
        Node nextNode = null;
        if(currNode!=null&&currNode.key==key){
                map[hashCode] = map[hashCode].next;
                return;
        }
        
        while(currNode!=null){
            nextNode = currNode.next;            
            if(currNode.key==key&&prevNode!=null){
                prevNode.next=nextNode;
                return;
            }
            prevNode = currNode;
            currNode = nextNode;
        }
    }
    
    public int getHash(int key){
        return key % 227;
    }
}
