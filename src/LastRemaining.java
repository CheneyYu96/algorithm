/**
 * a better way to solve last remaining problem, O(n) time cost and O(1) space cost
 * assume f(n,m) is a func to find the last element between n elements, deleting the m from 0 each time
 * there a map between a cut out and the next. (x-k-1)%n ,and the reverse map is (x+k+1)%n
 *
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/21
 */
public class LastRemaining {

    public int find(int n, int m){
        if(n<1 || m<1){
            return -1;
        }

        return (find(n-1, m) + m)%n;
    }

    public int findByLoop(int n, int m){
        if(n<1 || m<1){
            return -1;
        }
        int last = 0;
        for(int i = 2; i <= n; i++){
            last = (last + m) % i;
        }
        return last;
    }
    public static void main(String[] args) {
        System.out.println(new LastRemaining().findByLoop(6, 3));
    }
}
