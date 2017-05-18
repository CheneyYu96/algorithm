import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/18
 */
public class PostOrderTree {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null){
            return ret;
        }
        TreeNode node = root, pre =  null;
        while(node != null || !stack.empty()){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else {
                node = stack.peek();
                node = node.right;
                if(node != null && node != pre){
                    stack.push(node);
                    node = node.left;
                }
                else {
                    node = stack.pop();
                    ret.add(node.val);
                    pre = node;
                    node = null;
                }
            }
        }
        return ret;

    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}