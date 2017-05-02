import java.util.ArrayList;
import java.util.List;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/2
 */
public class RemoveBox {
    public int removeBoxes(int[] boxes) {
        int len = boxes.length;
        int[][] mem = new int[len+1][len+1];
        return removeSubBoxes(mem, boxes,0, len);
    }

    private int removeSubBoxes(int[][] mem, int[] boxes, int left, int right){
        if(left + 1 == right){
            return 1;
        }
        else if(left >= right){
            return 0;
        }
        if(mem[left][right] != 0){
            return mem[left][right];
        }

        int max = 0;
        int leftValue = boxes[left];
        List<Integer> indexes = new ArrayList<>();
        for(int i = left; i < right; i++){
            if(boxes[i] == leftValue){
                indexes.add(i);
                int tmp = 0;
                for(int j = 0; j < indexes.size()-1; j++){
                    tmp += removeSubBoxes(mem, boxes, indexes.get(j) + 1, indexes.get(j + 1));
                }
                tmp += removeSubBoxes(mem, boxes, indexes.get(indexes.size()-1) + 1, right);
                tmp += indexes.size() * indexes.size();
                max = Math.max(max, tmp);
            }
        }
        mem[left][right] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveBox().removeBoxes(new int[]{1, 3, 2, 2, 2, 3, 4, 3, 1}));
    }
}
