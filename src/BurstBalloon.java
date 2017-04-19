import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/19
 */
public class BurstBalloon {

    public int maxCoins(int[] nums) {
        int sum = 0;
        if(nums.length==0){
            return 0;
        }
        else if(nums.length==1){
            return nums[0];
        }


        List<Node> nodes = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i++){
            if(i == 0){
                nodes.add(new Node(1,nums[0],nums[1]));
            }
            else if(i == nums.length-1){
                nodes.add(new Node(nums[i-1],nums[i],1));
            }
            else {
                nodes.add(new Node(nums[i-1],nums[i],nums[i+1]));
            }
        }

        nodes.sort(Comparator.comparingInt(n -> n.value));
        for(Node o : nodes) {
            System.out.println(o.left + " " + o.value + " "+ o.right);
            sum += o.left * o.value * o.right;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new BurstBalloon().maxCoins(new int[]{3, 1, 5, 8}));
    }

}

class Node{
    int value;
    int left;
    int right;

    public Node(int left, int value,int right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}