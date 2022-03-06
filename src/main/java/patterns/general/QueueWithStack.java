package patterns.general;

import java.util.Stack;

/*
* https://leetcode.com/problems/implement-queue-using-stacks/
* Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions
* of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:
You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty
operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque
(double-ended queue) as long as you use only a stack's standard operations.
* Example 1:
Input
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 1, 1, false]
Explanation
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false
Constraints:
1 <= x <= 9
At most 100 calls will be made to push, pop, peek, and empty.
All the calls to pop and peek are valid.
Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words,
performing n operations will take overall O(n) time even if one of those operations may take longer.
*
* */
public class QueueWithStack {
    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;
    private int front;
    public QueueWithStack(){
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /*
    * Complexity Analysis:
        Time complexity : O(1).
        Аppending an element to a stack is an O(1) operation.
        Space complexity : O(n). We need additional memory to store the queue elements
    * */
    public void push(int x){
        if(pushStack.isEmpty()){
            front =   x;
        }
        pushStack.push(x);
    }

    /*
    * Time complexity : O(1).
        The front element was either previously calculated or returned as a top element of stack s2. Therefore complexity is O(1)
        Space complexity : O(1).
    * */
    public int peek(){
        if(!popStack.isEmpty()){
            return popStack.peek();
        }
        return front;
    }

    /*
    *
    * Complexity Analysis:
        Time complexity: Amortized O(1), Worst-case O(n).
        In the worst case scenario when stack s2 is empty, the algorithm pops nn elements from stack s1 and pushes n
        elements to s2, where nn is the queue size. This gives 2n2n operations, which is O(n). But when stack s2 is
        not empty the algorithm has O(1) time complexity. So what does it mean by Amortized O(1)? Please see
        the next section on Amortized Analysis for more information.
        Space complexity : O(1).
    * */
    public int pop(){
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public boolean isEmpty(){
        return popStack.isEmpty() && pushStack.isEmpty();
    }
}
