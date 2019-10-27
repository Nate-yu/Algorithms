import java.util.Scanner;
import java.util.Stack;

/**
 * @author Nate yu
 * @date 2019/10/27 - 16:35
 */
public class Evaluate {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>(); // 字符
        Stack<Double> vals = new Stack<Double>(); // 数字
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) { // 读取字符，如果是运算符则压入栈
            String s = scanner.next();
            if (s.equals("("))  ; // 如果是左括号，忽略
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")")) { // 如果为右括号，弹出运算符和操作数，计算结果并压入栈
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            }
            else
                vals.push(Double.parseDouble(s)); // 如果字符既不是运算符也不是括号，将其作为double值压入栈
        }
        System.out.println(vals.pop());
    }
}
