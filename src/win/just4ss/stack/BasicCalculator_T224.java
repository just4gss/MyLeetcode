package win.just4ss.stack;

import java.util.Stack;

public class BasicCalculator_T224 {
    /*
    224. 基本计算器
    给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
    示例 1：
    输入：s = "1 + 1"
    输出：2
    示例 2：
    输入：s = " 2-1 + 2 "
    输出：3
    示例 3：
    输入：s = "(1+(4+5+2)-3)+(6+8)"
    输出：23
    提示：
    1 <= s.length <= 3*10^5
    s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
    s 表示一个有效的表达式
    来源：力扣（LeetCode）
    链接：https://leetcode-cn.com/problems/basic-calculator
    著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static int calculate(String s) {
        //0.初始化2个栈，一个数栈、一个符号栈
        Stack<Integer>   stackNum        = new Stack<>();
        Stack<Character> stackAction     = new Stack<>();
        //1.去掉空格
        int tempNum = 0;
        char[] strCharArray = s.replaceAll(" ", "").toCharArray();
        int length = strCharArray.length;
        for(int i=0;i<length;i++) {
            char ch = strCharArray[i];
            if(ch == '+' || ch == '-') {
                //"1-(-2)"避免这种
                //"-2+ 1"
                if(i==0 || strCharArray[i-1]=='(') {
                    stackNum.push(0);
                }
                if(!stackAction.isEmpty() && (stackAction.peek() == '+' || stackAction.peek() == '-')) {
                    doCalc(stackNum,stackAction);
                }
                stackAction.push(ch);
            }else if(ch == '(') {
                stackAction.push('(');
            }else if(ch == ')') {
                //遇到右括号，在操作栈里一直运算，直到遇到左括号
                doCalc(stackNum,stackAction);
                if (!stackAction.isEmpty() && stackAction.peek() == '(') {
                    stackAction.pop();
                }
            }else {
                //是数字
                int curr = ch - '0';
                tempNum = 10 * tempNum + curr;
                //如果下一位不是数字，数字进栈
                if(i==length -1 || (i<length-1 && !Character.isDigit(strCharArray[i+1]))) {
                    stackNum.push(tempNum);
                    tempNum = 0;
                }
            }
        }
        doCalc(stackNum,stackAction);
        return stackNum.pop();
    }


    private static void doCalc(Stack<Integer> stackNum,Stack<Character> stackAction){
        while(!stackAction.isEmpty() && stackAction.peek() != '(') {
            int numB = 0;
            int numA = 0;
            if(!stackNum.isEmpty()) {
                numA = stackNum.pop();
            }
            if(!stackNum.isEmpty()) {
                numB = stackNum.pop();
            }
            Character ch = stackAction.pop();
            if(ch == '+') {
                stackNum.push(numB + numA);
            }else if(ch == '-') {
                stackNum.push(numB - numA);
            }
        }


    }
    public static void main(String[] args) {
//        String s  = "(-1+(4+5+2)-3)+(6+8)";
        String s  = "2-4-(8+2-6+(8+4-(1)+8-10))";
        System.out.println(calculate(s));
    }
}
