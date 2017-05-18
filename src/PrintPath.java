/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/18
 */
public class PrintPath {
    public void print(int[][] a, int m, int n){
        int len = m + n - 2;
        for(int i = 0; i <= len; i++){
            if(i%2 == 0){
                for(int j = Math.min(i,m-1); j>=0; j--){
                    if( j<m && (i-j)<n) {
                        System.out.print(a[j][i - j]);
                    }
                }
            }
            else {
                for(int j = 0; j <= Math.min(i, m-1); j++){
                    if( j<m && (i-j)<n) {
                        System.out.print(a[j][i - j]);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        new PrintPath().print(a, 3,4);
    }

}
