/**
 * count the number of 1 from 1 to n
 * reference : http://blog.csdn.net/yi_afly/article/details/52012593
 *
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/14
 */
public class NumberOfOne {

    public int count(int n){
        if(n<1) {
            return 0;
        }

        int count = 0;
        int base = 1;
        int round = n;

        while(round>0){
            int weight = round % 10;
            round /= 10;
            count += round * base;

            // when base == 1 result is the same
            if(weight == 1) {
                count += (n % base) + 1;
            }
            else if(weight>1) {
                count += base;
            }

            base *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfOne numberOfOne = new NumberOfOne();
        System.out.println(numberOfOne.count(213561231));
    }
}
