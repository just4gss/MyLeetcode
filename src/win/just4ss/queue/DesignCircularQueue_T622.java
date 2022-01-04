package win.just4ss.queue;

public class DesignCircularQueue_T622 {
    /*
    622. Design Circular Queue
    设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
    循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。
    但是使用循环队列，我们能使用这些空间去存储新的值。
    你的实现应该支持如下操作：
    MyCircularQueue(k): 构造器，设置队列长度为 k 。
    Front: 从队首获取元素。如果队列为空，返回 -1 。
    Rear: 获取队尾元素。如果队列为空，返回 -1 。
    enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
    deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
    isEmpty(): 检查循环队列是否为空。
    isFull(): 检查循环队列是否已满。
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/design-circular-queue
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    static class MyCircularQueue {

        private int[] items;
        private int length;
        private int tail = 0;
        private int head = 0;

        public MyCircularQueue(int k) {
            //多给一位，便于判断是满了还是空的
            items = new int[k+1];
            length = k+1;
        }

        public boolean enQueue(int value) {
            if(isFull()) return false;
            items[tail] = value;
            tail = (tail + 1) % length;
            return true;
        }

        public boolean deQueue() {
            if(isEmpty()) return false;
            head = (head + 1) % length;
            return true;
        }
//    Front: 从队首获取元素。如果队列为空，返回 -1 。
//    Rear: 获取队尾元素。如果队列为空，返回 -1 。
        public int Front() {
            if(isEmpty()) return -1;
            return items[head];
        }

        public int Rear() {
            if(isEmpty()) return -1;
            //尾巴+长度-1再摩长度
            return items[(tail+length-1) %length];
        }

        public boolean isEmpty() {
            //头尾相同
            return head == tail;
        }

        public boolean isFull() {
            //头尾只差1
            return (tail + 1) % length == head;
        }
    }

    //【1,2,3,4,5,6】
    //【0,1,2,3,4,5】
    //item[0] = 1; tail = 1;
    //item[1] = 2; tail = 2;
    //item[2] = 3; tail = 3;
    //item[3] = 4; tail = 4;
    //item[4] = 5; tail = 5;
    //item[5] = 6; tail = 6;


    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        myCircularQueue.enQueue(1); // return True
        myCircularQueue.enQueue(2); // return True
        myCircularQueue.enQueue(3); // return True
        myCircularQueue.enQueue(4); // return False
        myCircularQueue.Rear();     // return 3
        myCircularQueue.isFull();   // return True
        myCircularQueue.deQueue();  // return True
        myCircularQueue.enQueue(4); // return True
        myCircularQueue.Rear();     // return 4

    }
}
