package win.just4ss.stack;

import java.util.Stack;

public class ImplementQueueusingStacks_T232 {
    /*
    请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
    实现 MyQueue 类：
    void push(int x) 将元素 x 推到队列的末尾
    int pop() 从队列的开头移除并返回元素
    int peek() 返回队列开头的元素
    boolean empty() 如果队列为空，返回 true ；否则，返回 false
    说明：
    你只能使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
    你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
    进阶：
    你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
    示例：
    输入：
    ["MyQueue", "push", "push", "peek", "pop", "empty"]
    [[], [1], [2], [], [], []]
    输出：
    [null, null, null, 1, 1, false]
    解释：
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    myQueue.peek(); // return 1
    myQueue.pop(); // return 1, queue is [2]
    myQueue.empty(); // return false
    提示：
    1 <= x <= 9
    最多调用 100 次 push、pop、peek 和 empty
    假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */
    class MyQueue {
        Stack<Integer>  instack;
        Stack<Integer>  outstack;
        public MyQueue() {
            instack  = new Stack<>();
            outstack = new Stack<>();
        }

        //把A的都拿出来给B
        private void swithStack(Stack<Integer> stackA, Stack<Integer> stackB) {
            while (!stackA.isEmpty()) {
                stackB.push(stackA.pop());
            }
        }

        public void push(int x) {
            if(instack.isEmpty()) {
                swithStack(outstack,instack);
            }
            instack.push(x);
        }

        public int pop() {
            if(outstack.isEmpty()) {
                swithStack(instack,outstack);
            }
            return outstack.pop();
        }

        public int peek() {
            if(outstack.isEmpty()) {
                swithStack(instack,outstack);
            }
            return outstack.peek();
        }

        public boolean empty() {
            return instack.isEmpty() && outstack.isEmpty();
        }
    }


}
