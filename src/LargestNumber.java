import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/22
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> sortString = Arrays
                .stream(nums)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());

        sortString.sort(LargestNumber::sort);

        String res = sortString
                .stream()
                .reduce("", (s1 , s2) -> s1 + s2 );
        if(res.charAt(0)=='0'){
            res = "0";
        }
        return res;
    }

    private static int sort(String s1, String s2) {
        String t1 = s1 + s2;
        String t2 = s2 + s1;
        for(int i = 0; i< t1.length();i++){
            if(t1.charAt(i) < t2.charAt(i)){
                return 1;
            }
            else if(t1.charAt(i) > t2.charAt(i)){
                return -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        System.out.println(new LargestNumber().largestNumber(new int[]{121,12}));
    }
}
