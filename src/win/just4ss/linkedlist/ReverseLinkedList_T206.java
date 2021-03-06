package win.just4ss.linkedlist;

public class ReverseLinkedList_T206 {
    /*
    206. 反转链表
    给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
    示例 1：
    输入：head = [1,2,3,4,5]
    输出：[5,4,3,2,1]

    示例 2：
    输入：head = [1,2]
    输出：[2,1]

    示例 3：
    输入：head = []
    输出：[]
    提示：
    链表中节点的数目范围是 [0, 5000]
    -5000 <= Node.val <= 5000
    进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/reverse-linked-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode reverseList(ListNode head) {
        ListNode cursor = head;
        ListNode result = null;
        ListNode temp = null;
        while (cursor != null) {
            temp = cursor.next;//保存原来顺序
            cursor.next = result;//反转
            result = cursor;//后移
            cursor = temp;
        }
        return result;
    }
}
