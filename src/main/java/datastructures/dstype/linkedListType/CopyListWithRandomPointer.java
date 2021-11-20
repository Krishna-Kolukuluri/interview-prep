package datastructures.dstype.linkedListType;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    public RandomNode copyRandomList(RandomNode head) {
        if (head == null) return null;

        Map<RandomNode, RandomNode> map = new HashMap<RandomNode, RandomNode>();

        // loop 1. copy all the nodes
        RandomNode node = head;
        while (node != null) {
            map.put(node, new RandomNode(node.val));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
