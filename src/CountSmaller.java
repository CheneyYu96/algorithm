import java.util.ArrayList;
import java.util.List;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/9
 */
public class CountSmaller {
    Node root;
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> re = new ArrayList<>();
        if(nums.length == 0){
            return re;
        }
        else if(nums.length == 1){
            re.add(0);
            return re;
        }

        root = new Node(nums[nums.length - 1],0, 0);
        re.add(0, root.ans);
        for(int i = nums.length - 2; i >=0; i--){
            re.add(0,insertNode(root, nums[i]));
        }
        return re;
    }

    private int insertNode(Node parent,int val){
        if(parent.val < val){
            if(parent.right == null){
                parent.right = new Node(val, parent.leftNum + 1, parent.leftNum + 1);
                return parent.leftNum + 1;
            }
            else {
                return insertNode(parent.right, val);
            }
        }
        else if(parent.val > val){
            if(parent.left == null){
                parent.left = new Node(val, parent.leftNum,parent.leftNum);
                parent.leftNum++;
                return parent.left.ans;
            }
            else {
                parent.leftNum++;
                return insertNode(parent.left, val);
            }
        }
        else {
            return parent.leftNum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new CountSmaller().countSmaller(new int[]{-1,-2}));
    }
}

class Node{
    Node left;
    Node right;
    int val;
    int leftNum;
    int ans;

    public Node(int val, int leftNum, int ans) {
        this.val = val;
        this.leftNum = leftNum;
        this.ans = ans;
    }
}