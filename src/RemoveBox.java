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
//                int tmp = 0;
//                for(int j = 0; j < indexes.size()-1; j++){
//                    tmp += removeSubBoxes(mem, boxes, indexes.get(j) + 1, indexes.get(j + 1));
//                }
//                tmp += removeSubBoxes(mem, boxes, indexes.get(indexes.size()-1) + 1, right);
//                tmp += indexes.size() * indexes.size();
//                max = Math.max(max, tmp);
            }
        }

        int size = indexes.size();
        for(int i = 0; i < size; i++){
            for(int j = i; j < size; j++){
                int tmp = removeSubBoxes(mem, boxes, left, indexes.get(i));
                for(int k = i; k < j; k++){
                    tmp += removeSubBoxes(mem, boxes, indexes.get(k) + 1, indexes.get(k + 1));
                }
                tmp += removeSubBoxes(mem, boxes, indexes.get(j) + 1, right);
                tmp += (j - i + 1) * (j - i + 1);
                max = Math.max(max, tmp);
            }
        }
        mem[left][right] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveBox().removeBoxes(new int[]{3, 8, 8, 5, 5, 3, 9, 2, 4, 4, 6, 5, 8, 4, 8, 6, 9, 6, 2, 8, 6, 4, 1, 9, 5, 3, 10, 5, 3, 3, 9, 8, 8, 6, 5, 3, 7, 4, 9, 6, 3, 9, 4, 3, 5, 10, 7, 6, 10, 7}));
    }
}
