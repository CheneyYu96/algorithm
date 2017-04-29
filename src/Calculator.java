import java.util.Stack;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/29
 */
public class Calculator {
    public int calculate(String s) {
        String postOrder = inToPost(s);
        Stack<Integer> numberStack = new Stack<>();
        String[] spl = postOrder.split(" ");
        for (String aSpl : spl) {
            if (aSpl.equals("")) {
                continue;
            }
            switch (aSpl) {
                case "-":
                    int second = numberStack.pop();
                    int first = numberStack.pop();
                    numberStack.push(first - second);
                    break;

                case "+":
                    numberStack.push(numberStack.pop() + numberStack.pop());
                    break;

                case "*":
                    numberStack.push(numberStack.pop() * numberStack.pop());
                    break;

                case "/":
                    int secondDivide = numberStack.pop();
                    int firstDivide = numberStack.pop();
                    numberStack.push(firstDivide - secondDivide);
                    break;

                // number
                default:
                    numberStack.push(Integer.parseInt(aSpl));
            }
        }
        if(numberStack.size() > 0){
            return numberStack.pop();
        }
        return -1;
    }
    private String inToPost(String inOrder){
        Stack<Character> operator = new Stack<>();
        StringBuilder sb = new StringBuilder();
        inOrder = inOrder.trim();

        int i = 0;
        while (i<inOrder.length()){
            char c = inOrder.charAt(i);
            if(c <= '9' && c >= '0'){
                int num = c - '0';
                i++;
                while ( i < inOrder.length() && (c = inOrder.charAt(i))<= '9' && c >= '0'){
                    num = num * 10 + c - '0';
                    i++;
                }
                sb.append(num).append(" ");
                continue;
            }
            else if( c == '-' || c == '+'){
                while (operator.size() > 0){
                    char top = operator.peek();
                    if(top == '*' || top == '/' || top == '+' || top == '-'){
                        sb.append(operator.pop()).append(" ");
                    }
                    else {
                        break;
                    }
                }
                operator.push(c);
            }
            else if(c == '*' || c == '/'){
                while (operator.size() > 0){
                    char top = operator.peek();
                    if(top == '*' || top == '/'){
                        sb.append(operator.pop()).append(" ");
                    }
                    else {
                        break;
                    }
                }
                operator.push(c);
            }
            else if(c == '('){
                operator.push(c);
            }
            else if(c == ')'){
                while (operator.size() > 0){
                    char top = operator.peek();
                    if(top != '('){
                        sb.append(operator.pop()).append(" ");
                    }
                    else {
                        operator.pop();
                        break;
                    }
                }
            }
            i++;
        }

        while (operator.size() > 0){
            sb.append(operator.pop()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().calculate(" 2-1 + 2 "));
    }
}
