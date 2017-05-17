import java.util.Stack;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/17
 */
public class TreeJudge {

    public boolean isATree(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '#'){
                if(stack.empty()){
                    return false;
                }
                else {
                    int last = stack.pop();
                    if(last == 1){
                        stack.push(0);
                    }
                }
            }
            else {
                if(stack.empty()){
                    stack.push(1);
                }
                else {
                    int last = stack.pop();
                    if(last == 1){
                        stack.push(0);
                    }
                    stack.push(1);
                }
            }
        }
        return stack.empty();
    }


    public static void main(String[] args) {
        System.out.println(new TreeJudge().isATree("1#23#4###"));
    }
}
