package win.just4ss.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI_T496 {
    //496. Next Greater Element I
    /*
    nums1中数字x的 下一个更大元素 是指x在nums2 中对应位置 右侧 的 第一个 比x大的元素。
    给你两个 没有重复元素 的数组nums1 和nums2 ，下标从 0 开始计数，其中nums1是nums2的子集。
    对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，
    并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
    返回一个长度为nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
    示例 1：
    输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
    输出：[-1,3,-1]
    解释：nums1 中每个值的下一个更大元素如下所述：
    - 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
    - 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
    - 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
    示例 2：
    输入：nums1 = [2,4], nums2 = [1,2,3,4].
    输出：[3,-1]
    解释：nums1 中每个值的下一个更大元素如下所述：
    - 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
    - 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
    提示：
    1 <= nums1.length <= nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 104
    nums1和nums2中所有整数 互不相同
    nums1 中的所有整数同样出现在 nums2 中
    进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/next-greater-element-i
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //单调栈
        Stack<Integer> stack = new Stack<>();
        int num2Length = nums2.length;
        HashMap<Integer,Integer> map = new HashMap<>(num2Length);
        //逆序进栈，栈空无后续更大元素，栈顶比该元素大那他就是该元素的Next greater element；不是pop掉，比较下一个
        for (int i=num2Length-1; i>=0; i--) {
            int curr = nums2[i];
            while(!stack.isEmpty() && stack.peek()<curr) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                map.put(curr,-1);
            }else {
                map.put(curr,stack.peek());
            }
            stack.push(curr);
        }
        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) {
            result[i] = map.get(nums1[i]);
        }
        return  result;
    }
}
