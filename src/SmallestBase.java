import java.math.BigInteger;

/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/1
 */
public class SmallestBase {

    public String smallestGoodBase(String n) {
        long value = Long.valueOf(n);
        for(int i = 62; i > 1; i--){
            long l = 2;
            long h = value;
            while (l <= h){
                long mid = l + (h - l)/2;
                BigInteger f =  BigInteger.valueOf(mid).pow(i).subtract(BigInteger.ONE);
                BigInteger s = BigInteger.valueOf(value).multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                if(f.compareTo(s) == 0){
                    return String.valueOf(mid);
                }
                else if (f.compareTo(s) > 0){
                    h = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
        }
        return String.valueOf(value-1);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestBase().smallestGoodBase("14919921443713777"));
    }

}
