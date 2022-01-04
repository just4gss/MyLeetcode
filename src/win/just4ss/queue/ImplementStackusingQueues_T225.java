package win.just4ss.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ImplementStackusingQueues_T225 {
    //225.Implement Stack using Queues
    /*
    请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
    实现 MyStack 类：
    void push(int x) 将元素 x 压入栈顶。
    int pop() 移除并返回栈顶元素。
    int top() 返回栈顶元素。
    boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
    注意：
    你只能使用队列的基本操作 —— 也就是push to back、peek/pop from front、size 和is empty这些操作。
    你所使用的语言也许不支持队列。你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列, 只要是标准的队列操作即可。

    示例：
    输入：
    ["MyStack", "push", "push", "top", "pop", "empty"]
    [[], [1], [2], [], [], []]
    输出：
    [null, null, null, 2, 2, false]

    解释：
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    myStack.top(); // 返回 2
    myStack.pop(); // 返回 2
    myStack.empty(); // 返回 False
    提示：
    1 <= x <= 9
    最多调用100 次 push、pop、top 和 empty
    每次调用 pop 和 top 都保证栈不为空
    进阶：你能否实现每种操作的均摊时间复杂度为 O(1) 的栈？换句话说，执行 n 个操作的总时间复杂度 O(n) ，尽管其中某个操作可能需要比其他操作更长的时间。你可以使用两个以上的队列。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/implement-stack-using-queues
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    //1 2 3 4
    //4 3 2 1

    //和232类似
    class MyStack {
        Queue<Integer> inputQueue;
        Queue<Integer> outputQueue;
        public MyStack() {
            inputQueue = new LinkedList<>();
            outputQueue = new LinkedList<>();
        }

        public void push(int x) {
            if(inputQueue.isEmpty()) {
                switchQueue(outputQueue, inputQueue);
            }
            inputQueue.offer(x);
        }

        public int pop() {
            if (outputQueue.isEmpty()) switchQueue(inputQueue,outputQueue);
            return outputQueue.poll();
        }

        public int top() {
            if (outputQueue.isEmpty()) switchQueue(inputQueue,outputQueue);
            return outputQueue.peek();
        }

        public boolean empty() {
            return inputQueue.isEmpty() && outputQueue.isEmpty();
        }

        private void switchQueue(Queue<Integer> queueA, Queue<Integer> queueB) {
            while(!queueA.isEmpty()) {
                queueB.offer(queueB.poll());
            }
        }
    }

}
