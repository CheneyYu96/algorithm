import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public List<Integer> postOrder(TreeNode root){
        List<Integer> ret = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            TreeNode node = stack.pop();
            ret.add(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }

        Collections.reverse(ret);
        return ret;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n3.right = n4;
        System.out.println(new PostOrderTree().postorderTraversal(n1));
        System.out.println(new PostOrderTree().postOrder(n1));
    }

}


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}