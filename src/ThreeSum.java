import java.util.*;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/20
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for(int i : nums){
            if(i>=0){
                pos.add(i);
            }
            else {
                neg.add(i);
            }
        }

        Set<Integer> posSet = new HashSet<>(pos);
        Set<Integer> negSet = new HashSet<>(neg);

        long cnt  = pos
                .stream()
                .filter( o -> o==0)
                .count();

        if(cnt>=3){
            ret.add(Arrays.asList(0 ,0 ,0));
        }
        pos.sort(Integer::compareTo);
        neg.sort(Integer::compareTo);
        search(ret,negSet,pos, -1);

        search(ret,posSet,neg, 1);

        return ret;
    }

    private void search(List<List<Integer>> ret, Set<Integer> set, List<Integer> list, int last){
        int first = last, second;
        for(int i = 0; i<list.size() ;i++ ){
            if(list.get(i) == first) continue;
            else first = list.get(i);
            second = last;
            for(int j = i +1; j<list.size();j++){
                if(list.get(j)==second) continue;
                else second = list.get(j);
                if(set.contains((list.get(i) + list.get(j))*-1)){
                    ret.add(Arrays.asList(list.get(i),list.get(j), (list.get(i) + list.get(j))*-1));
                }
            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> res = new ThreeSum().threeSum(new int[]{-1, -1 ,0 ,0 ,0, 1, 1, 1});
        res.forEach( o ->
        {
            o.forEach(System.out::print);
            System.out.println();
        });
    }
}
