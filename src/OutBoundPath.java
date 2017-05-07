/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/5/7
 */
public class OutBoundPath {

    public int findPaths(int m, int n, int N, int i, int j) {
        int count = 0;
        int mem[][][] = new int[m][n][N+1];
        for(int times = N; times > 0; times--){
            count += findSubPaths(m, n, times, i, j, mem);
        }
        return count;
    }

    private int findSubPaths(int m, int n, int N, int i, int j, int[][][] mem) {
        if(N == 0){
            return 0;
        }
        if(mem[i][j][N] != 0){
            return mem[i][j][N];
        }
        if(N == 1){
            int count = 0;
            if(i == 0){
                count++;
            }
            if(i == m-1){
                count++;
            }
            if(j == 0){
                count++;
            }
            if(j == n-1){
                count++;
            }
            return count;
        }

        int count = 0;
        count += i > 0 ? findSubPaths(m, n, N-1, i-1, j,mem) : 0;
        count += i < m-1 ? findSubPaths(m, n, N-1, i+1, j, mem) : 0;
        count += j > 0 ? findSubPaths(m, n, N-1, i, j-1, mem) : 0;
        count += j < n-1 ? findSubPaths(m, n, N-1, i, j+1, mem) : 0;
        mem[i][j][N] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new OutBoundPath().findPaths(8,50,23,5,26));
    }
}
