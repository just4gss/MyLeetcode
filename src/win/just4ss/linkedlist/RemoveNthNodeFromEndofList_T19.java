package win.just4ss.linkedlist;

public class RemoveNthNodeFromEndofList_T19 {
    /*
    19. 删除链表的倒数第 N 个结点
    示例 1：
    输入：head = [1,2,3,4,5], n = 2
    输出：[1,2,3,5]
    示例 2：
    输入：head = [1], n = 1
    输出：[]
    示例 3：
    输入：head = [1,2], n = 1
    输出：[1]

    提示：
    链表中结点的数目为 sz
    1 <= sz <= 30
    0 <= Node.val <= 100
    1 <= n <= sz
    进阶：你能尝试使用一趟扫描实现吗？

    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //快慢指针，快指针先走n步，然后快慢一起走，快指针走完了，慢指针把节点删了即可
        ListNode dummy = new ListNode(0,head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = n; i > 0; i--) {
            fast = fast.next;
        }
        //快指针的下一个不是空，快慢指针后移
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        //慢指针删除元素
        slow.next = slow.next.next;
        return dummy.next;
    }
}
