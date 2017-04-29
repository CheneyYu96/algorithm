import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/29
 */
public class TwentyFour {
//    public List<String> find(int a, int b, int c, int d){
//        List<Integer> arrays = Arrays.asList(a,b,c,d);
//
//        List<List<Integer>> lists = permutation(arrays, 0);
//
//    }

    private List<List<Integer>> permutation(List<Integer> array, int index, int bound){

        List<List<Integer>> re = new ArrayList<>();
        if(index == bound){
            re.add(new ArrayList<>());
            return re;
        }
        for(int i = 0; i < array.size(); i++){
            int val = array.get(i);
            array.remove(i);
            List<List<Integer>> sub = permutation(array, index+1, bound);
            sub.forEach(o -> o.add(0, val));
            re.addAll(sub);
            array.add(i, val);
        }
        return re;
    }

    public static void main(String[] args) {
        List<Integer> in = new LinkedList<>();
        in.add(1);
        in.add(2);
        in.add(3);
        in.add(4);
        List<List<Integer>> lists = new TwentyFour().permutation(in,0,4);
        lists.forEach(
                o -> {
                    o.forEach(System.out::print);
                    System.out.println();
                }

        );

    }
}
