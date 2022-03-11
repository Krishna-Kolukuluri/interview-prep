package salesforce;

import java.util.HashSet;

public class LowestCommonAncestor {
    
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    };
    
    public Node lowestCommonAncestorHashSet(Node p, Node q) {
        HashSet<Node> hs = new HashSet();
        while(p != null){
            hs.add(p);
            p = p.parent;
        }
        while(q != null){
            if(hs.contains(q)) return q;
            q = q.parent;
        }
        return null;
    }

    public Node lowestCommonAncestor(Node p, Node q) {
        Node pParent = p;
        Node qParent = q;
        
        while (pParent != qParent) {
            pParent = pParent.parent != null ? pParent.parent : q;
            qParent = qParent.parent != null ? qParent.parent : p;
        }
        return pParent;
    }
}
