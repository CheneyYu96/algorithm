/**
 * @author yuminchen
 * @version V1.0
 * @date 2017/4/27
 */
public class NQueen {

    int cnt;
    public int totalNQueens(int n){
        cnt = 0;
        int[] board = new int[n];
        find(0,n,board);
        return cnt;
    }

    private void find(int line, int n, int[] board){
        if(line==n){
            cnt++;
            return;
        }
        for(int i = 0; i < n; i++){
            board[line] = i;
            boolean isOK = true;
            for(int j = 0; j < line; j++){
                if(board[line] == board[j] || Math.abs(board[line] - board[j]) == Math.abs(line - j)){
                    isOK = false;
                    break;
                }
            }
            if(isOK) {
                find(line + 1, n, board);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new NQueen().totalNQueens(8));
    }
}
