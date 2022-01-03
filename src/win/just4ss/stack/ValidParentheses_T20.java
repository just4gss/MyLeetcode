package win.just4ss.stack;

import java.util.Stack;

public class ValidParentheses_T20 {
    //20. Valid Parentheses
    /*
    给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    示例 1：
    输入：s = "()"
    输出：true
    示例2：
    输入：s = "()[]{}"
    输出：true
    示例3：
    输入：s = "(]"
    输出：false
    示例4：
    输入：s = "([)]"
    输出：false
    示例5：
    输入：s = "{[]}"
    输出：true
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/valid-parentheses
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        //左括号进栈
        //右括号找对应的左括号，没有就false
        //更好的方法
        //遇到左括号，对应的右括号进栈
        //如果不是左括号，就检查当前栈顶是不是自己，不是就fales
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch=='(') stack.push(')');
            else if(ch=='[') stack.push(']');
            else if(ch=='{') stack.push('}');
            else if(stack.isEmpty() || stack.pop()!=ch) return false;
        }
        return stack.isEmpty();

    }
}
