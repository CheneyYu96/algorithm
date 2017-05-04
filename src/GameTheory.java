/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/4
 */
public class GameTheory {

    /**
     * bash game is about removing max m from a heap(n), judge if the first can win
     * use mod:
     * if there remain k * (m + 1), the next to remove will never win
     *
     * @param n
     * @param m
     * @return
     */
    public boolean bashGame(int n, int m){
      return n%m != 0;
    }


    /**
     * nim game is about removing from n heaps, player can remove any number in each turn
     * use OR, reference : http://blog.csdn.net/theprinceofelf/article/details/7221775
     *
     * @param n
     * @param values
     * @return
     */
    public boolean nimGame(int n, int[] values){
        int re = 0;
        for(int i = 0; i < n; i++){
            re ^= values[i];
        }
        return re!=0;
    }

    /**
     * wythoff game is about removing either any number from one of these two heep,
     * or equal number from both of two heep
     * use golden section, in most case, the first is easy to win
     *
     * @param a
     * @param b
     * @return
     */
    public boolean wythoffGame(int a, int b){
        int min = Math.min(a, b);
        int max = a + b - min;
        int k = max - min;
        double goldenSection = 1.618033;
        return min == (int)Math.floor(goldenSection * k);

    }
}
